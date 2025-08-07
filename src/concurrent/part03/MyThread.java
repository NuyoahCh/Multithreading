package concurrent.part03;

/**
 * @author wangchen
 * @version 1.0
 */
public class MyThread extends Thread {
    // 单继承方式，耦合性高
    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
    }
}

class ThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}
