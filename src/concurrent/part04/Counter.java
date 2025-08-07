package concurrent.part04;

/**
 * @author wangchen
 * @version 1.0
 */
public class Counter {

    private int count = 0;

    // 非原子操作
    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
