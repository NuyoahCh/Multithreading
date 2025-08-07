package part01;

/**
 * @author wangchen
 * @version 1.0
 * 对于静态同步方法，锁是当前类的 Class 对象
 */
public class SynchronizedObject03 implements Runnable {

    Object lock = new Object();

    @Override
    public void run() {
        method();
    }

    // synchronized 用在静态方法中，默认的锁就是当前所在的 Class 类
    // 所以无论是哪个线程访问它，需要的锁都只有一把，因为 instance1 和 instance2 对应的类Class对象是同一个
    public static synchronized void method() {
        // 方法体
        System.out.println("Static synchronized method executed by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // 模拟一些工作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Static synchronized method completed by " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        SynchronizedObject03 instance1 = new SynchronizedObject03();
        SynchronizedObject03 instance2 = new SynchronizedObject03();

        // 创建多个线程来调用静态同步方法
        Thread thread1 = new Thread(SynchronizedObject03::method, "Thread-1");
        Thread thread2 = new Thread(SynchronizedObject03::method, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
