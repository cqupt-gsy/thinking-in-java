package programming.practise.concurrency.classes;

import programming.practise.concurrency.examples.queue.MyQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreExample implements MyQueue {

    private final List<String> queue;
    private final Semaphore semaphore;

    public SemaphoreExample(int bound) {
        this.semaphore = new Semaphore(bound);
        this.queue = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public void put(String value) throws InterruptedException {
        this.semaphore.acquire();
        boolean result = false;
        try {
            result = this.queue.add(value);
        } finally {
            if (!result) {
                this.semaphore.release();
            }
        }
    }

    @Override
    public String take() throws InterruptedException {
        String result = this.queue.remove(0);
        if (result != null) {
            this.semaphore.release();
        }
        return result;
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
