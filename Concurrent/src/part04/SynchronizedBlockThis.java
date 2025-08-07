package part04;

/**
 * @author wangchen
 * @version 1.0
 */
public class SynchronizedBlockThis {
    // 锁住当前实例对象
    private int value = 0;

    public void addValue(int amount) {
        // 使用 this 锁，确保同一个对象的所有线程对 addValue 方法的调用是互斥的
        synchronized (this) {
            value += amount;
            System.out.println(Thread.currentThread().getName() + " added " + amount + ", new value: " + value);
        }
    }
}
