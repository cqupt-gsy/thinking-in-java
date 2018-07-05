package programming.practise.concurrency.classes;

import programming.practise.concurrency.examples.queue.MyQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreExample implements MyQueue {

    private final List<String> queue;
    private final Semaphore semaphore;

    //信号量是控制总共有多少执行者可以进入，无论是同步的还是异步的
    //也就是说当acquire的次数到达bound值后就会被阻塞，无论是多个线程并发执行acquire操作，还是单个线程执行多次acquire操作
    //具体看main方法里面的测试，这里程序就会被阻塞
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

    public static void main(String args[]) throws InterruptedException {
        SemaphoreExample semaphoreExample = new SemaphoreExample(10);
        for (int i = 0; i < 15; i++) {
            System.out.println("start insert: " + (i+1));
            semaphoreExample.put("test");
            System.out.println("end insert: " + (i+1));
        }
    }

}
