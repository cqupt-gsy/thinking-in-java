package programming.practise.concurrency.examples.queue;

import java.util.LinkedList;
import java.util.List;

public class BoundBlockQueueWithSync implements MyQueue{

    private int size;
    private final List<String> queue;
    private int count;

    public BoundBlockQueueWithSync(int size) {
        this.size = size - 1;
        this.queue = new LinkedList<>();
        this.count = -1;
    }

    @Override
    public String take() throws InterruptedException {
        synchronized (queue) {
            while (count == -1) {
                System.out.println(Thread.currentThread().getName() + ": start take block with sync lock!");
                queue.wait();
                System.out.println(Thread.currentThread().getName() + ": release take block with sync lock!");
            }
            final String result = queue.remove(0);
            if (result != null) {
                count--;
                queue.notify();
            }
            return result;
        }
    }

    @Override
    public void put(String value) throws InterruptedException {
        synchronized (queue) {
            while (count == size) {
                System.out.println(Thread.currentThread().getName() + ": start put block with sync lock!");
                queue.wait();
                System.out.println(Thread.currentThread().getName() + ": release put block with sync lock!");
            }
            final boolean result = queue.add(value);
            if (result) {
                count++;
                queue.notify();
            }
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
