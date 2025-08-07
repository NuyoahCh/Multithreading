package concurrent.part03;

/**
 * @author wangchen
 * @version 1.0
 */
public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread useThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("User thread is running: " + i);
                try {
                    Thread.sleep(1000); // 模拟用户线程的工作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("User thread has finished execution.");
        });

        Thread daemonThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Daemon thread is running: " + i);
                try {
                    Thread.sleep(500); // 模拟守护线程的工作
                } catch (InterruptedException e) {
                    System.out.println("Daemon thread interrupted: " + e.getMessage());
                    return;
                }
            }
            System.out.println("Daemon thread has finished execution.");
        });

        daemonThread.setDaemon(true);

        useThread.start();
        daemonThread.start();

        System.out.println("Main thread is doing other work while user and daemon threads are running.");
    }
}
