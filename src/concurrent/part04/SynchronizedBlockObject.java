package concurrent.part04;

/**
 * @author wangchen
 * @version 1.0
 */
public class SynchronizedBlockObject {
    private final Object lock = new Object(); // 锁对象
    private int data = 0;

    public void processData(int value) {
        // 使用 lock 对象进行同步，确保同一时刻只有一个线程可以执行这个代码块
        synchronized (lock) {
            data += value;
            System.out.println(Thread.currentThread().getName() + " processed data: " + data);
        }
    }
}
