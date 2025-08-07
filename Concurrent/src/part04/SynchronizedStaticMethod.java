package part04;

/**
 * @author wangchen
 * @version 1.0
 */
public class SynchronizedStaticMethod {
    // 无论多少个实例，所有线程调用 SynchronizedStaticMethod 的静态方法时，都会互斥
    // 这意味着所有线程对静态方法的访问是同步的，只有一个线程可以执行静态方法中的代码块，其他线程必须等待。。因为锁的是同一个对象
    private static int staticCount = 0;

    public static synchronized void incrementStatic() {
        staticCount++;
        System.out.println(Thread.currentThread().getName() + " incremented staticCount to: " + staticCount);
    }

    public static synchronized void decrementStatic() {
        staticCount--;
        System.out.println(Thread.currentThread().getName() + " decremented staticCount to: " + staticCount);
    }
}
