package part01;

/**
 * @author wangchen
 * @version 1.0
 */
public class Target implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("测试 synchronized");
        }
    }

    // 测试方法
    public static synchronized void target() {
        System.out.println("测试静态 synchronized");
    }

    public static void main(String[] args) {

    }
}
