package concurrent.part05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangchen
 * @version 1.0
 */
public class BoundedBuffer {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Queue<Object> items = new LinkedList<>();
    private final int capacity;

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (items.size() == capacity) {
                System.out.println(Thread.currentThread().getName() + " waiting to put: " + x);
                notFull.await(); // 等待直到缓冲区不满
            }
            items.add(x);
            System.out.println(Thread.currentThread().getName() + " put: " + x);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (items.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " waiting to take");
                notEmpty.await(); // 等待直到缓冲区不空
            }
            Object x = items.remove();
            System.out.println(Thread.currentThread().getName() + " took: " + x);
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
