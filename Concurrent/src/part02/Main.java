package part02;

import java.util.concurrent.TimeUnit;

/**
 * @author wangchen
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();
        TimeUnit.SECONDS.sleep(2);
        testThread1.interrupt();
    }

    private static class TestThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(20000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread interrupted" + Thread.currentThread().isInterrupted());
            }
        }
    }
}
