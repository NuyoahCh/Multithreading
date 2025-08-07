package concurrent.part03;

/**
 * @author wangchen
 * @version 1.0
 */
public class VolatileVisibilityTest {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(() -> {
            while (running) {
                // 模拟工作
            }
            System.out.println("Worker thread has stopped.");
        });

        workerThread.start();

        // 主线程等待一段时间后停止工作线程
        Thread.sleep(2000);
        running = false; // 设置为 false，通知工作线程停止

        workerThread.join(); // 等待工作线程结束
        System.out.println("Main thread has finished execution.");
    }
}
