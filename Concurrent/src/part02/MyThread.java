package part02;

/**
 * @author wangchen
 * @version 1.0
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("用继承 Thread 类的方式创建线程");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
