package 并发.JUC.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {
    Lock lock = new ReentrantLock();

    void func1() {
        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void func2() {
        boolean locked = false;

        try {
            // tryLock: 在指定时间内没有获取到锁就放弃
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("fun2 " + locked);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        new Thread(demo2 :: func1).start();
        new Thread(demo2 :: func2).start();
    }
}
