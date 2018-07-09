package programming.practise.concurrency.examples.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundBlockQueueWithLock implements MyQueue{

    private int size;
    private final List<String> queue;
    private int count;

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundBlockQueueWithLock(int size) {
        this.size = size - 1;
        this.queue = new LinkedList<>();
        this.count = -1;
    }

    @Override
    public String take() throws InterruptedException {
        Lock tempLock = lock;
        tempLock.lockInterruptibly();
        try {
            while (count == -1) { //使用while循环的原因是怕信号丢失，当线程获取到锁之前，状态已经被其他线程改变了
                System.out.println(Thread.currentThread().getName() + ": start take block with lock!");
                notEmpty.await();
                System.out.println(Thread.currentThread().getName() + ": release take block with lock!");
            }
            final String result = queue.remove(0);
            if (result != null) {
                count--;
                notFull.signal();
            }
            return result;
        } finally {
            tempLock.unlock();
        }
    }

    @Override
    public void put(String value) throws InterruptedException {
        Lock tempLock = lock;
        tempLock.lockInterruptibly();
        try {
            while (count == size) {
                System.out.println(Thread.currentThread().getName() + ": start put block with lock!");
                notFull.await();
                System.out.println(Thread.currentThread().getName() + ": release put block with lock!");
            }
            final boolean result = queue.add(value);
            if (result) {
                count++;
                notEmpty.signal();
            }
        } finally {
            tempLock.unlock();
        }
    }

    @Override
    public String poll() {
        return null;
    }

    @Override
    public boolean offer(String value) {
        return false;
    }
}
