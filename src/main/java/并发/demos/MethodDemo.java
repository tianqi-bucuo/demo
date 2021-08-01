package 并发.demos;

public class Demo1 {

    // sleep：线程暂停一段时间
    static void sleepTest() {
        new Thread(() -> {
           for (int i = 0; i < 100; i++) {
               System.out.println(i);
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();
    }

    // yield：让出CPU使用权，加入到等待队列和别的线程竞争CPU(有可能下次还是这个线程拿到CPU)
    static void yieldTest() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A---" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("B---" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();
    }

    // join：一个线程加入到当前线程，直到加入的线程结束，当前线程再重新开始运行
    static void joinTest() {
        Thread t1= new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1---" + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2= new Thread(() -> {
            try {
                t1.join();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 10; i++) {
                System.out.println("t2---" + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
//        sleepTest();
//        yieldTest();
        joinTest();
    }
}
