package concurrent.part05;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangchen
 * @version 1.0
 */
public class CachedData {
    private final Map<String, String> cache = new HashMap<>();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public String get(String key) {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading key: " + key);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // 恢复中断状态
            }
            return cache.get(key);
        } finally {
            System.out.println(Thread.currentThread().getName() + " finished reading key: " + key);
            readLock.unlock();
        }
    }

    public void put(String key, String value) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing key: " + key);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // 恢复中断状态
            }
            cache.put(key, value);
        } finally {
            System.out.println(Thread.currentThread().getName() + " finished writing key: " + key);
            writeLock.unlock();
        }
    }
}
