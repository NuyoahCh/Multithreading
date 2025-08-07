package concurrent.part04;

/**
 * @author wangchen
 * @version 1.0
 */
public class ReentrantExample {

    public synchronized void outerMethod() {
        System.out.println(Thread.currentThread().getName() + " entered outerMethod");
        innerMethod(); // 调用内部方法
        System.out.println(Thread.currentThread().getName() + " exiting outerMethod");
    }

    public synchronized void innerMethod() {
        System.out.println(Thread.currentThread().getName() + " entered innerMethod");
        // 模拟一些工作
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 恢复中断状态
        }
        System.out.println(Thread.currentThread().getName() + " exiting innerMethod");
    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        new Thread(example::outerMethod, "Thread-1").start();
    }
}
