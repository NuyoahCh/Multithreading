package concurrent.part01;

/**
 * @author wangchen
 * @version 1.0
 * 对于同步方法块，锁是 Synchronized 括号里面制定的对象
 */
public class SynchronizedObject02 implements Runnable {
    Object lock = new Object();

    @Override
    public void run() {
        // 同步方法块，锁指定对象 lock
        // 两个线程同时执行时，只有一个线程能进入同步方法块，目标是锁住 lock，竞争成功的线程运行完成之后下一个线程才会执行
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                // 模拟执行任务
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished running");
        }
    }

    public static void main(String[] args) {
        SynchronizedObject02 instance = new SynchronizedObject02();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }
}
