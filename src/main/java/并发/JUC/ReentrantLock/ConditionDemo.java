package 并发.JUC.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        try{
            if(lock.tryLock()){
                System.out.println("await...");
                // 对应内置锁的wait
                condition.await();
            }
        }finally {
            lock.unlock();
            System.out.println("signal...");
            // 对应内置锁的notify
            condition.signal();
        }
    }
}
