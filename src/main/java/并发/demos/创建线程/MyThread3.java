package 并发.demos.创建线程;

import java.util.concurrent.Callable;

public class MyThread3 implements Callable<String>{
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(3000);
        return "线程3";
    }
}
