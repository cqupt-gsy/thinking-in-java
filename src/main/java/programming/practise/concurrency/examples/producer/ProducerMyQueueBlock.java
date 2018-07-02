package programming.practise.concurrency.examples.producer;

import programming.practise.concurrency.examples.queue.MyQueue;

import java.util.concurrent.CountDownLatch;

public class ProducerMyQueueBlock implements Runnable {

    private MyQueue sharedQueue;
    private CountDownLatch countDownLatch;

    public ProducerMyQueueBlock(MyQueue sharedQueue, CountDownLatch countDownLatch) {
        this.sharedQueue = sharedQueue;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 1; i < 20; i++) {
            try {
                final long startTime = System.currentTimeMillis();
                sharedQueue.put(String.format("%s create task[%d]", Thread.currentThread().getName(), i));
                final long endTime = System.currentTimeMillis();
                System.out.println(String.format("%s create task[%d] in [%sms]", Thread.currentThread().getName(), i, (endTime - startTime)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("%s producing finished", Thread.currentThread().getName()));
        this.countDownLatch.countDown();
    }
}
