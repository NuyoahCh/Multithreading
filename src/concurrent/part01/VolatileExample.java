package concurrent.part01;

import java.util.concurrent.TimeUnit;

/**
 * @author wangchen
 * @version 1.0
 */
public class VolatileExample {

    private static volatile boolean stop = false;

    public static void main(String[] args) {
        // 启动一个线程A
        new Thread("Thread A") {
            @Override
            public void run() {
                while (!stop) {
                    // 模拟一些工作
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
                System.out.println("线程A结束运行");
            }
        }.start();

        // 启动主线程
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("主线程等待 1 秒后设置 stop 为 true");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("stop = true");
        stop = true; // 设置 stop 为 true，通知线程A停止
    }
}
