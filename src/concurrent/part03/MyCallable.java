package concurrent.part03;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author wangchen
 * @version 1.0
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Callable " + Thread.currentThread().getName() + " is running.");
        Thread.sleep(2000); // 模拟长时间运行的任务
        return "Task completed by " + Thread.currentThread().getName();
    }
}

class CallableExample {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread t1 = new Thread(futureTask, "Thread-1");
        t1.start();

        System.out.println(Thread.currentThread().getName() + " is doing other work while waiting for the callable to complete.");
        try {
            String result = futureTask.get(); // 阻塞等待 callable 任务完成
            System.out.println("Result from callable: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Main thread " + Thread.currentThread().getName() + " has finished execution.");
    }
}