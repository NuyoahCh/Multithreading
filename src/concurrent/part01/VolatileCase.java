package concurrent.part01;

/**
 * @author wangchen
 * @version 1.0
 */
public class VolatileCase {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1; // 写操作
        flag = true; // 设置标志位为 true
    }
    public void reader() {
        if (flag) { // 读取标志位
            int i = a; // 读取 a 的值
            System.out.println("a = " + i); // 输出 a 的值
        }
    }
}
