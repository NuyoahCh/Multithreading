package concurrent.part04;

/**
 * @author wangchen
 * @version 1.0
 */
public class VisibilityExample {
    // 修改可见性的问题
    private boolean flag = true;

    // 线程 A 修改
    public void stop() {
        flag = false; // 修改了flag的值
    }

    public void runLoop() {
        while (flag) { // 线程 B 读取
            // do something
        }
        System.out.println("Loop stopped");
    }
}
