package 并发.并发容器;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<Integer> queue = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // transfer后会阻塞直到别的线程取走
        queue.transfer(1);
        // put不会阻塞
        queue.put(2);
        System.out.println(queue);
    }
}
