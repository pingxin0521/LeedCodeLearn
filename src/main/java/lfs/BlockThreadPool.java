package lfs;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义阻塞线程池 当池满时阻塞任务提交线程
 * 通过将队列的offer改为put方法（阻塞），把TreadPool改造成阻塞队列，任务超过线程数量将会阻塞
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test09
 * hyp create at 20-2-18
 **/
public class BlockThreadPool {
    private ThreadPoolExecutor pool = null;

    public BlockThreadPool(int poolSize) {
        pool = new ThreadPoolExecutor(poolSize, poolSize, 0, TimeUnit.MILLISECONDS
                , new ArrayBlockingQueue<Runnable>(poolSize)
                , new CustomThreadFactory(), new CustomRejectedExecutionHandler());
    }

    /**
     * 自定义线程工厂，自定义线程名
     */
    private class CustomThreadFactory implements ThreadFactory {
        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = BlockThreadPool.class.getSimpleName() + count.addAndGet(1);
            t.setName(threadName);
            return t;
        }
    }

    /**
     * 更改默认拒绝策略
     */
    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                // 核心改造，由blockingqueue的offer改成put阻塞方法
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 包装execte方法
     *
     * @param runnable
     */
    public void execute(Runnable runnable) {
        this.pool.execute(runnable);
    }

    /**
     * 关闭线程池
     */
    public void shutdown() {
        this.pool.shutdown();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int tNums = Runtime.getRuntime().availableProcessors() + 1;
        BlockThreadPool pool = new BlockThreadPool(tNums);
        try {

            for (int i = 1; i < 100; i++) {
                System.out.println("提交第" + i + "个任务");
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println(Thread.currentThread().getId() + "=====开始");
                            TimeUnit.SECONDS.sleep(10);
                            System.out.println(Thread.currentThread().getId() + "=====结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                System.out.println("提交第" + i + "个任务成功");
            }
        } finally {
            pool.shutdown();

        }
    }

}
