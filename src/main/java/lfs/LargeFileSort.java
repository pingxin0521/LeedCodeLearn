package lfs;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test09
 * hyp create at 20-2-18
 **/
public class LargeFileSort {
    private final static String ROOT_FILE_PATH = "/home/hyp/dev/data";

    private final static String TMP_FILE_PATH = ROOT_FILE_PATH + "/tmp";


    private final static String FINAL_FILE_PATH = ROOT_FILE_PATH + "/res";

    // 测试文件
    private static String[] genFiles = new String[10];
    // 切分大文件的512k, 默认为 512k
    private final static int SIZE = 1 << 19;
    // 线程任务完成计数器
    private static CountDownLatch doneSignal;
    // 切分文件,使用CopyOnWriteArrayList
    private static final List<File> divFiles = new CopyOnWriteArrayList<>();

    //数据库连接池
    private static BlockThreadPool pool = null;

    public static void main(String[] args) throws IOException {
        pool = new BlockThreadPool(3);

        //确保文件夹存在
        File f1 = new File(ROOT_FILE_PATH);
        if (f1.exists()) {
            f1.delete();
        }
        f1.mkdir();
        f1 = new File(FINAL_FILE_PATH);
        if (f1.exists()) {
            f1.delete();
        }
        f1.mkdir();
        f1 = new File(TMP_FILE_PATH);
        if (f1.exists()) {
            f1.delete();
        }
        f1.mkdir();


        long genStart = System.currentTimeMillis();
        //生成测试数据
        generateTestFiles();
        long genEnd = System.currentTimeMillis();

        System.out.println("\n************");
        System.out.println(String.format("初始化数据完成：%s s", (genEnd - genStart) / 1000));
        System.out.println("************");


        long divStart = System.currentTimeMillis();
        //切分大文件成排序好的小文件，参数为参与的线程数量
        divisionAndSortFiles();

        long divEnd = System.currentTimeMillis();
        System.out.println("\n************");
        System.out.println(String.format("切分数据完成数据完成：%s s", (divEnd - divStart) / 1000));
        System.out.println("************");

        long mergeStart = System.currentTimeMillis();
        //合并小文件为一个文件
        mergeFiles();


        long mergeEnd = System.currentTimeMillis();
        System.out.println("\n************");
        System.out.println(String.format("合并完成数据完成：%s s", (mergeEnd - mergeStart) / 1000));
        System.out.println("************");

        // 验证
        validation();

        //拆分为十个文件
        divFinalFiles();

        System.out.println(
                String.format("排序完成:%s s。 %s 分钟 。", (mergeEnd - divStart) / 1000, (mergeEnd - divStart) / 1000 / 60));
        System.out.println("***************");
        System.out.println("最终文件地址：" + FINAL_FILE_PATH);
        System.out.println("文件包括");
        divFiles.forEach(System.out::println);


        if (pool != null) {
            pool.shutdown();
        }
    }

    private static void validation() throws IOException {
        System.out.println("执行验证");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(divFiles.get(0).getAbsolutePath())));
        String line = "";
        String pre = br.readLine();
        while ((line = br.readLine()) != null) {
            if (Integer.parseInt(line.trim()) < Integer.parseInt(pre.trim())) {
                System.out.println("验证不通过");
                System.exit(0);
            }
        }
        System.out.println("验证通过");
    }


    /**
     * 产生测试文件
     */

    public static void generateTestFiles() {
        // 多个线程生成测试文件
        BlockThreadPool executorService = pool;

        doneSignal = new CountDownLatch(10);
        for (int i = 0; i < genFiles.length; i++) {
            genFiles[i] = ROOT_FILE_PATH + File.pathSeparator + "originalData" + i + ".txt";
            executorService.execute(new GenerateFileTask(genFiles[i]));
        }
        try {
            // 等待生成文件
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class GenerateFileTask implements Runnable {
        final String filePath;

        public GenerateFileTask(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void run() {
            try {
                generateTestFile(filePath);
                //任务执行完毕递减
                doneSignal.countDown();
                System.out.println("生成文件：" + doneSignal.getCount());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void generateTestFile(String filePath) throws Exception {
        Random random = new Random();
        //拼接
        StringBuilder sb = new StringBuilder();
        //连接文件
        FileChannel fc = null;
        RandomAccessFile raf = null;
        try {
            File tf = new File(filePath);
            //存在则删除，最终新建一个文件
            if (tf.exists()) {
                tf.delete();
            }
            tf.createNewFile();

            //获取通道
            raf = new RandomAccessFile(tf, "rw");
            fc = raf.getChannel();

            //缓冲区大小,字节
            int cap = 1 << 20;
            ByteBuffer buffer = ByteBuffer.allocate(cap);

            //字节
            for (int i = 0; i < 10000 * 1000; i++) {
                sb.append(random.nextInt(Integer.MAX_VALUE)).append("\n");
                //刷新缓存
                if ((i + 1) % 10000 == 0) {
                    buffer.put(sb.toString().getBytes());
                    sb.setLength(0);
                    buffer.flip();
                    fc.write(buffer);
                    buffer.clear();
                }
            }
            if (sb.length() > 0) {
                buffer.put(sb.toString().getBytes());
                sb.setLength(0);
                buffer.flip();
                fc.write(buffer);
                buffer.clear();
            }


        } catch (Exception e) {
            System.out.println("生成测试文件失败！" + e.getMessage());
            throw e;
        } finally {
            if (raf != null) {
                raf.close();
            }
            if (fc != null) {
                fc.close();
            }

        }
    }

    /**
     * 将文件分隔并排序
     */
    public static void divisionAndSortFiles() {
        int num = 10;
        //切分任务
        doneSignal = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            pool.execute(new DivWorkTask(genFiles[i]));
        }
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分割文件task
     */
    static class DivWorkTask implements Runnable {
        final String filePath;

        public DivWorkTask(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void run() {
            try {
                List<File> files = divWork(filePath);
                //将分隔的文件存入
                divFiles.addAll(files);
                //任务完毕递减锁存器
                doneSignal.countDown();
                System.out.println("完成分割任务：" + doneSignal.getCount());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static List<File> divWork(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("文件不存在");
        }
        //文件大小
        int mbsize = (int) Math.ceil(file.length() >> 10);
        //切分后的文件数
        int fileNum = (int) Math.ceil((int) (file.length() / mbsize)) + 1;

        //临时文件
        List<File> tempFiles = createTempFiles(file, fileNum);

        //切分文件
        divAndSort(file, tempFiles);

        return tempFiles;
    }

    /**
     * 创建临时文件
     *
     * @param file
     * @param num
     * @return
     */
    public static List<File> createTempFiles(File file, Integer num) throws Exception {
        List<File> files = new ArrayList<>();
        String name = file.getName();
        for (Integer i = 0; i < num; i++) {
            //创建临时文件
            File tmpfile = new File(TMP_FILE_PATH + File.pathSeparator + name + ".temp+" + i + ".txt");
            if (!tmpfile.exists()) {
                tmpfile.delete();
            }
            tmpfile.createNewFile();
            files.add(tmpfile);
        }
        return files;
    }

    /**
     * 切分文件并做第一次排序
     *
     * @param file
     * @param fileList
     */
    public static void divAndSort(File file, List<File> fileList) {
        //读取大文件
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(file)
                             ))) {
            String name = file.getName();
            //行数据保存对象
            String line = null;
            //临时文件索引
            int index = fileList.size() - 1;
            //保存数据
            ArrayList<String> lineList = new ArrayList<>();
            //统计文件大小
            int byteSum = 0;
            // 循环临时文件并循环大文件
            while ((line = reader.readLine()) != null) {
                line += "\n";
                byteSum += line.getBytes().length;
                //如果长度达到每个文件大小则重新计算
                if (byteSum >= SIZE) {
                    long t1 = System.currentTimeMillis();
                    //写入到文件
                    putLineListToFile(fileList.get(index), lineList);
                    long t2 = System.currentTimeMillis();
                    System.out.println(String.format("写入文件%s：%s ms", name+index, t2 - t1));
                    index--;
                    byteSum = line.getBytes().length;
                    lineList.clear();

                }
                lineList.add(line);
            }
            if (lineList.size() > 0) {
                //写入到文件
                putLineListToFile(fileList.get(0), lineList);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 把数据写到临时文件
     *
     * @param file
     * @param lineList
     * @throws IOException
     */
    public static void putLineListToFile(File file, List<String> lineList) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            // 第一次写入文件时，调用Collection.sort进行内部排序
            lineList.sort(new LineComparator());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lineList.size(); i++) {
                sb.append(lineList.get(i));
                if ((i + 1) % 1000 == 0) {
                    fos.write(sb.toString().getBytes());
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) {
                fos.write(sb.toString().getBytes());
            }

            sb = null;
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * 使用异步IO
     *
     * @param file
     * @param lineList
     * @throws IOException
     */
    public static void putLineListToFileNIO(File file, List<String> lineList) throws IOException {
        Path path = Paths.get(file.getAbsolutePath());
        AsynchronousFileChannel fc = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(1 << 19);
        Future<Integer> ope = null;
        try {
            // 第一次写入文件时，调用Collection.sort进行内部排序
            lineList.sort(new LineComparator());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lineList.size(); i++) {
                sb.append(lineList.get(i));
                if ((i + 1) % 1000 == 0) {
                    if (ope != null) {
                        while (!ope.isDone()) {

                        }
                    }
                    buffer.put(sb.toString().getBytes());
                    buffer.flip();
                    ope = fc.write(buffer, 0);
                    buffer.clear();
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) {
                buffer.put(sb.toString().getBytes());
                buffer.flip();
                ope = fc.write(buffer, 0);
                buffer = null;

            }
            sb = null;
        } finally {
            if (ope != null) {
                while (!ope.isDone()) {

                }
            }
            fc.force(true);
            if (fc.isOpen()) {
                fc.close();
            }
        }

    }


    /**
     * 合并为大文件，再拆分
     *
     * @throws IOException
     */
    private static void mergeFiles() throws IOException {
        //文件数过少直接合并
        if (divFiles.size() < 20) {
            mergeLargeFile(divFiles, ROOT_FILE_PATH + File.pathSeparator + "resultFile.txt");
            return;
        }
        while (divFiles.size()>20)
        {
            mergeFilesToFile();
        }
        System.out.println("最终合并");
        // 最终合并
        File resultFile = mergeLargeFile(divFiles, ROOT_FILE_PATH + File.pathSeparator + "temp_reslt_all.txt");
        divFiles.clear();
        divFiles.add(resultFile);

    }

    public static void mergeFilesToFile() throws IOException {
        ArrayList<File> files2 = new ArrayList<>(divFiles);
        divFiles.clear();

        List<List<File>> divTwo = new ArrayList();
        // 划分任务，15个为一组
        for (int i = 0; i < files2.size(); i += 15) {
            List<File> files = new ArrayList();
            for (int j = i; j < files2.size() && j < (i + 15); j++) {
                files.add(files2.get(j));
            }
            divTwo.add(files);
        }

        doneSignal = new CountDownLatch(divTwo.size());
        for (int i = 0; i < divTwo.size(); i++) {
            pool.execute(new MergeTask(divTwo.get(i), ROOT_FILE_PATH + File.pathSeparator + "temp_reslt" + i + ".txt"));
        }
        try {
            // 等待合并文件完成
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    /**
     * 合并任务
     */
    static class MergeTask implements Runnable {
        private final List<File> files;
        private final String fn;

        public MergeTask(List<File> fs, String f) {
            this.files = fs;
            this.fn = f;
        }

        @Override
        public void run() {
            try {
                File file = mergeLargeFile(files, fn);
                divFiles.add(file);
                // 任务执行完毕递减锁存器
                doneSignal.countDown();
                System.out.println("完成合并任务：" + doneSignal.getCount());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        }
    }

    /**
     * 把临时文件合并到结果文件
     *
     * @param fs
     * @param f
     * @return
     */
    public static File mergeLargeFile(List<File> fs, String f) throws IOException {
        ArrayList<FileEntity> entities = new ArrayList<>();
        for (int i = 0; i < fs.size(); i++) {
            FileEntity entity = new FileEntity(
                    new BufferedReader(new InputStreamReader(new FileInputStream(fs.get(i))))
            );
            entities.add(entity);
        }
        BufferedWriter bw = null;

        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
        int count = 0;
        FileEntity fe = null;
        StringBuilder sb = new StringBuilder();
        while ((fe = getFirstFileEntity(entities)) != null) {
            count++;
            //写入符合条件的一行数据
            sb.append(fe.getLine()).append("\n");
            //准备下一行
            fe.nextLine();
            //清缓存
            if ((count + 1) % 10000 == 0) {
                bw.write(sb.toString());
                sb.setLength(0);
                bw.flush();
            }

        }
        if (sb.length() > 0) {
            bw.write(sb.toString());
            sb.setLength(0);
            bw.flush();
        }

        if (bw != null) {
            bw.flush();
            bw.close();
        }
        entities.forEach(FileEntity::close);
        return new File(f);
    }

    /**
     * 从切分的文件中按序行读取
     *
     * @param entities
     * @return
     */
    private static FileEntity getFirstFileEntity(List<FileEntity> entities) {
        if (entities == null || entities.size() == 0) {
            return null;
        }
        Iterator<FileEntity> it = entities.iterator();
        while (it.hasNext()) {
            FileEntity fe = it.next();
            // 如果文件读到完就关闭流和删除在集合的文件流
            if (fe.getLine() == null) {
                fe.close();
                it.remove();
            }
        }
        if (entities.size() == 0) {
            return null;
        }
        // 排序获取一行数据
        entities.sort(new FileEntityComparator());
        // 返回第一个符合条件的文件对象
        return entities.get(0);
    }


    public static void divFinalFiles() throws IOException {
        File resFile = divFiles.get(0);
        divFiles.clear();
        if (resFile == null) {
            return;
        }
        int fNum = 10;

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(resFile))
        );
        // 行数据保存对象
        String line = null;
        // 保存数据
        StringBuilder sb = new StringBuilder();

        int index = 0;

        File tmpFile = new File(FINAL_FILE_PATH + "/data_" + index + ".txt");
        if (!tmpFile.exists()) {
            tmpFile.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(tmpFile);

        //统计行数
        int lineSum = 0;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
            lineSum++;

            if (lineSum % 50 == 0) {
                fos.write(sb.toString().getBytes());
                sb.setLength(0);
                //长度达到10000000
                if (lineSum == 10000000) {

                    if (fos != null) {
                        fos.close();
                    }
                    divFiles.set(index, tmpFile);


                    index++;
                    lineSum = 0;
                    if (index >= fNum) {
                        break;
                    }
                    tmpFile = new File(FINAL_FILE_PATH + "/data_" + index + ".txt");
                    if (!tmpFile.exists()) {
                        tmpFile.createNewFile();
                    }
                    fos = new FileOutputStream(tmpFile);

                    sb.setLength(0);
                }
            }
        }

        if (sb.length() > 0 && fos != null) {
            fos.write(sb.toString().getBytes());
        }
        if (fos != null) {
            fos.close();
        }

        if (reader != null) {
            reader.close();
        }
    }


    /**
     * 比较器
     */
    static class LineComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            o1 = o1.trim();
            o2 = o2.trim();
            // 从小到大
            return Integer.parseInt(o1) - Integer.parseInt(o2);
            // 从大到小
            // return Integer.parseInt(o2) - Integer.parseInt(o1);
        }
    }

    /**
     * 比较器
     */
    static class FileEntityComparator implements Comparator<FileEntity> {

        @Override
        public int compare(FileEntity o1, FileEntity o2) {
            String s1 = o1.getLine().trim();
            String s2 = o2.getLine().trim();
            // 从小到大
            return Integer.parseInt(s1) - Integer.parseInt(s2);
            // 从大到小
            // return Integer.parseInt(o2) - Integer.parseInt(o1);
        }
    }


}
