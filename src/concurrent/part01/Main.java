package concurrent.part01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangchen
 * @version 1.0
 * 并发编程存在的不安全性
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 500;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}

class ThreadUnsafeExample {
    private int count = 0;

    public void add() {
        count++;
    }

    public int get() {
        return count;
    }
}