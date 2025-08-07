package part04;

/**
 * @author wangchen
 * @version 1.0
 */
public class Singleton {
    // 可能因指令重排导致问题
    // private volatile static Singleton instance;
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    // 可能发生指令重排，导致 instance 已经被初始化，但线程还未看到
                    instance = new Singleton(); // 1. 分配内存空间 2. 初始化对象 3. 设置 instance 指向新对象
                }
            }
        }
        return instance; // 可能返回未完全初始化的对象
    }
}
