package 并发.并发容器;

import java.util.concurrent.*;

public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayedObj o1 = new DelayedObj("o1", 1000);
        DelayedObj o2 = new DelayedObj("o2", 1500);
        DelayedObj o3 = new DelayedObj("o3", 2000);
        DelayedObj o4 = new DelayedObj("o4", 3000);

        // 实现了优先队列，越早过了延迟时间的越先被取出
        BlockingQueue<DelayedObj> delayedObjs = new DelayQueue<>();
        delayedObjs.put(o1);
        delayedObjs.put(o2);
        delayedObjs.put(o3);
        delayedObjs.put(o4);
        System.out.println(delayedObjs);

        // TimeUnit.SECONDS.sleep(4);
        for (int i = 0; i < 4; i++) {
            System.out.println(delayedObjs.take());
        }
    }

    // 存入DelayQueue的元素必须实现Delayed接口
    static class DelayedObj implements Delayed {
        private final String name;
        // 到了该时间才能被take(),具体逻辑在getDelay()方法中
        private final long availableTime;

        public DelayedObj(String name, long delayTime) {
            this.name = name;
            this.availableTime = System.currentTimeMillis() + delayTime;
        }

        // 还有多久元素才可以被取出
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(availableTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return "DelayedObj{" +
                    "name='" + name + '\'' +
                    ", availableTime=" + availableTime +
                    '}';
        }
    }
}
