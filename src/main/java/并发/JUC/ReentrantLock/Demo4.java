package 并发.JUC.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo4 implements Runnable{
    // 公平锁：先排队的线程获取到锁
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得所");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        Thread t1 = new Thread(demo4);
        Thread t2 = new Thread(demo4);
        Thread t3 = new Thread(demo4);
        // 因为是公平锁，所以每次肯定都是三个线程依次获取到锁
        t1.start();
        t2.start();
        t3.start();
    }
}
