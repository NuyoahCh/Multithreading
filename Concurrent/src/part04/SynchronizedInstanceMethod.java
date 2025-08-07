package part04;

/**
 * @author wangchen
 * @version 1.0
 */
public class SynchronizedInstanceMethod {
    // 多个线程调用同一个 SynchronizedInstanceMethod 对象的 increment 和 decrement 方法时，会出现互斥的现象
    // 不同对象的 SynchronizedInstanceMethod 实例之间不会互斥
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
    }

    public synchronized void decrement() {
        count--;
        System.out.println(Thread.currentThread().getName() + " decremented count to: " + count);
    }

}
