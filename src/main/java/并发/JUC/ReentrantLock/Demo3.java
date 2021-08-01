package 并发.JUC.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                // 在获取锁和持有锁时，都无法被中断，否则强行中断会抛出异常
                lock.lock();
                System.out.println("t1-start");
                // t1一直睡
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1-end");
            } catch (InterruptedException e) {
                System.out.println("被中断");
            }finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                // lockInterruptibly: 在获取锁和持有锁时可以被中断
                lock.lockInterruptibly();
                System.out.println("t2-start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t2-end");
            } catch (InterruptedException e) {
                System.out.println("t2被中断...");
            }
        });

        t1.start();
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断t2获取锁
        t2.interrupt();
    }
}