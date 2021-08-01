package 并发.JUC.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer {

    private int count = 0;

    private final static int FULL = 10;

    private Lock lock = new ReentrantLock();

    private Condition notEmptyCondition = lock.newCondition();

    private Condition notFullCondition = lock.newCondition();

    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    if (count == FULL) {
                        try {
                            notFullCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    count++;
                    System.out.println("生产者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                    notEmptyCondition.signal();
                } finally {
                    lock.unlock();
                }

            }

        }

    }

    class Consumer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();

                try {
                    if (count == 0) {
                        try {
                            notEmptyCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count--;
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                    notFullCondition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {

        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        for (int i = 1; i <= 10; i++) {
            new Thread(producerAndConsumer.new Producer(), "生产者-" + i).start();
            new Thread(producerAndConsumer.new Consumer(), "消费者-" + i).start();
        }
    }

}

