package concurrent.part02;

/**
 * @author wangchen
 * @version 1.0
 */
public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("用实现 Runnable 接口的方式创建线程");
    }

    public static void main(String[] args) {
        RunnableThread instance = new RunnableThread();
        Thread thread = new Thread(instance);
        thread.start();
    }
}
