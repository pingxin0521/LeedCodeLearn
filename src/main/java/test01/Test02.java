package test01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock和Executors
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-1-19
 **/
public class Test02 implements Runnable {
    private ReentrantLock lock = new ReentrantLock();

    private static int count;

    public int incAndGet() {
        try {
            lock.lock();
            Thread.sleep(5);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return count;

    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service =
                    Executors.newCachedThreadPool();
            int i = 100;
            for (int j = 0; j < i; j++) {
                service.execute(new Test02());
            }

        } finally {
            if (null != service && !service.isShutdown()) {
                service.shutdown();
            }

        }
        do{

        }while (!service.isTerminated());
        System.out.println(Test02.count);

    }

    @Override
    public void run() {
        incAndGet();
    }
}
