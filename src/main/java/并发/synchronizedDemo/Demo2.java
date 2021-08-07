package 并发.synchronizedDemo;

import java.util.concurrent.ConcurrentHashMap;

public class Demo2 {

    /**
     * jdk7: 分段锁(16段)
     * jdk8：cas+synchronized
     */
    ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    System.out.println((char) ('a' + i));
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }).start();
    }

}
