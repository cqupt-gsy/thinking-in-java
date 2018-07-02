package programming.practise.concurrency.examples.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundUnblockQueueWithLock implements MyQueue {

    private int size;
    private int count;
    private final List<String> queue;

    private Lock lock = new ReentrantLock();

    public BoundUnblockQueueWithLock(int size) {
        this.size = size - 1;
        this.queue = new LinkedList<>();
        this.count = -1;
    }

    @Override
    public String poll() {
        Lock tempLock = lock;
        tempLock.lock();
        try {
            if (count == -1) {
                return null;
            }
            final String result = queue.remove(0);
            count--;
            return result;

        } finally {
            tempLock.unlock();
        }
    }

    @Override
    public boolean offer(String value) {
        Lock tempLock = lock;
        tempLock.lock();
        try {
            if (count == size) {
                return false;
            }
            final boolean result = queue.add(value);
            count++;
            return result;
        } finally {
            tempLock.unlock();
        }
    }

    @Override
    public String take() throws InterruptedException {
        return null;
    }

    @Override
    public void put(String value) throws InterruptedException {

    }
}
