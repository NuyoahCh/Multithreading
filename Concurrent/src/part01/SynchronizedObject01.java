package part01;

/**
 * @author wangchen
 * @version 1.0
 * 对于普通同步方法，锁是当前实例对象
 */
public class SynchronizedObject01 implements Runnable {

    @Override
    public void run() {
        method();
    }

    // synchronized 定义普通同步方法，默认锁是当前实例对象，也就是 instance
    // 而两个线程 t1 和 t2 调用的是同一个实例对象 instance 的方法，所以会互斥，线程在此处会竞争锁，竞争成功的线程运行完成之后下一个线程才会执行
    public synchronized void method() {
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(1000); // 模拟耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished running");
    }

    public static void main(String[] args) {
        SynchronizedObject01 instance = new SynchronizedObject01();
        // 创建两个线程，调用同一个实例对象 instance 的 method 方法
        Thread t1 = new Thread(instance::method, "Thread-1");
        Thread t2 = new Thread(instance::method, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join(); // 等待线程 t1 完成
            t2.join(); // 等待线程 t2 完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Both threads have finished execution.");
    }


}
