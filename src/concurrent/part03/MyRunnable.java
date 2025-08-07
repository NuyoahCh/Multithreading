package concurrent.part03;

/**
 * @author wangchen
 * @version 1.0
 */
public class MyRunnable implements Runnable {

    // 实现Runnable接口，解耦性高，避免了单继承的局限性，类可以继承其他类，同时实现了 Runnable 接口
    @Override
    public void run() {
        System.out.println("Runnable " + Thread.currentThread().getName() + " is running.");
    }
}

class RunnableExample {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable, "Thread-1");
        Thread t2 = new Thread(runnable, "Thread-2");
        t1.start();
        t2.start();
    }
}