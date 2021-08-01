package 并发.并发容器;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    /**
     * 阻塞队列，它是基于ReentrantLock
     *
     * 1.入队
     * offer(E e)：如果队列没满，立即返回true； 如果队列满了，立即返回false(不阻塞)
     * put(E e)：如果队列满了，一直阻塞，直到队列不满了或者线程被中断(阻塞)
     * offer(E e, long timeout, TimeUnit unit)：在队尾插入一个元素,，如果队列已满，则进入等待(阻塞)直到出现以下三种情况(
     *  1)被唤醒
     *  2)等待时间超时
     *  3)当前线程被中断
     *
     * 2.出队
     * poll()：如果没有元素，直接返回null；如果有元素，出队
     * take()：如果队列空了，一直阻塞，直到队列不为空或者线程被中断-->阻塞
     * poll(long timeout, TimeUnit unit)：如果队列不空，出队；如果队列已空且已经超时，返回null；如果队列已空且时间未超时，则进入等待，直到出现以下三种情况：
     *  1)被唤醒
     *  2)等待时间超时
     *  3)当前线程被中断
     */
    public static void main(String[] args) {
        // 无界队列，内存满了之后的put才会阻塞
        BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        // 有界队列
        BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

        Random random = new Random();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    linkedBlockingQueue.put(random.nextInt(10000));
                    TimeUnit.MILLISECONDS.sleep(1);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "producer").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (;;) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " take " + linkedBlockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer" + i).start();
        }
    }
}
