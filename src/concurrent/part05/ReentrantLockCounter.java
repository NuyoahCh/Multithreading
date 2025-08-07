package concurrent.part05;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangchen
 * @version 1.0
 */
public class ReentrantLockCounter {
    private final Lock lock = new ReentrantLock(); // 使用 ReentrantLock 代替 synchronized
    private int count = 0;

    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
        } finally {
            lock.unlock(); // 确保在操作完成后释放锁
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count; // 获取当前计数值
        } finally {
            lock.unlock(); // 确保在操作完成后释放锁
        }
    }
}
