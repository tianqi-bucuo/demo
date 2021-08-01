package 并发.demos.创建线程;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadTest{

    //创建线程的第一种方式
    @Test
    public void test1(){
        Thread t1 = new MyThread1();
        t1.start();
    }

    //创建线程的第二种方式
    @Test
    public void test2(){
        Thread t2 = new Thread(new MyThread2());
        t2.start();
    }

    //创建线程的第三种方式
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        //首先创建一个线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //线程池提交线程任务的方法submit,返回 Future接口的实现类
        Future<String> future = es.submit(new MyThread3());
        System.out.println("开始执行");
        //通过get()方法得到线程运行的结果
        String s = future.get();
        System.out.println(s);
        //关闭线程池
        es.shutdown();

        // 不需要submit方法的返回值也能通过FutureTask的方法获取任务信息
        FutureTask<String> futureTask = new FutureTask<>(new MyThread3());
        es.execute(futureTask);
        System.out.println(futureTask.get());
    }

    @Test
    public void test4(){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 15,0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10));

    }

}
