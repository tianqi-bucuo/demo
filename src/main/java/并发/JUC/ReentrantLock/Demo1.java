package 并发.JUC.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
    Lock lock = new ReentrantLock();

    void func1() {
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
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
        try {
            lock.lock();
            System.out.println("func2");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        new Thread(demo1::func1).start();
        new Thread(demo1 :: func2).start();
    }
}
