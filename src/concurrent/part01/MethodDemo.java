package concurrent.part01;

/**
 * @author wangchen
 * @version 1.0
 */
public class MethodDemo {

    public static void main(String[] args) {
        MethodDemo demo = new MethodDemo();
        demo.method1();
    }

    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " is executing method1");
        try {
            Thread.sleep(1000); // 模拟耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method2();
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " is executing method2");
        try {
            Thread.sleep(1000); // 模拟耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method3();
    }

    public synchronized void method3() {
        System.out.println(Thread.currentThread().getName() + " is executing method3");
        try {
            Thread.sleep(1000); // 模拟耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
