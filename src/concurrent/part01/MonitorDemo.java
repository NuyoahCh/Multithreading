package concurrent.part01;

/**
 * @author wangchen
 * @version 1.0
 */
public class MonitorDemo {

    private int a = 0;

    public synchronized void writer() {
        a++;
    }

    public synchronized void reader() {
        int i = a;
    }
}
