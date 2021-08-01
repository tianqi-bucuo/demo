package 并发.并发容器;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // 用于两个线程之间传递数据，容量为0。put之后没有线程取就一直阻塞
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        queue.put(1);
    }
}
