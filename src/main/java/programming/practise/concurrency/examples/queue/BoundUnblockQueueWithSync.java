package programming.practise.concurrency.examples.queue;

import java.util.LinkedList;
import java.util.List;

public class BoundUnblockQueueWithSync implements MyQueue {

    private int size;
    private int count;
    private final List<String> queue;

    public BoundUnblockQueueWithSync(int size) {
        this.size = size - 1;
        this.queue = new LinkedList<>();
        this.count = -1;
    }

    @Override
    public String poll() {
        synchronized (queue) {
            if (count == -1) {
                return null;
            }
            final String result = queue.remove(0);
            count--;
            return result;
        }
    }

    @Override
    public boolean offer(String value) {
        synchronized (queue) {
            if (count == size) {
                return false;
            }
            final boolean result = queue.add(value);
            count++;
            return result;
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
