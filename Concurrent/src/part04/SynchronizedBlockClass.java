package part04;

/**
 * @author wangchen
 * @version 1.0
 */
public class SynchronizedBlockClass {
    // 锁住类的 Class 对象
    private static int staticValue = 0;
    public void addStaticValue(int amount) {
        // 使用 SynchronizedBlockClass.class 锁，确保所有线程对 addStaticValue 方法的调用是互斥的
        synchronized (SynchronizedBlockClass.class) {
            staticValue += amount;
            System.out.println(Thread.currentThread().getName() + " added " + amount + ", new staticValue: " + staticValue);
        }
    }
}
