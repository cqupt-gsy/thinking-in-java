package programming.practise.concurrency.examples.producer;

import programming.practise.concurrency.examples.queue.MyQueue;

import java.util.concurrent.CountDownLatch;

public class ProducerMyQueueUnblock implements Runnable {

    private MyQueue sharedQueue;
    private CountDownLatch countDownLatch;

    public ProducerMyQueueUnblock(MyQueue sharedQueue, CountDownLatch countDownLatch) {
        this.sharedQueue = sharedQueue;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 1; i < 20; i++) {
            final long startTime = System.currentTimeMillis();
            final boolean result = sharedQueue.offer(String.format("%s create task[%d]", Thread.currentThread().getName(), i));
            final long endTime = System.currentTimeMillis();
            if (result) {
                System.out.println(String.format("%s create task[%d] in [%sms]", Thread.currentThread().getName(), i, (endTime - startTime)));
            }
        }
        System.out.println(String.format("%s producing finished", Thread.currentThread().getName()));
        this.countDownLatch.countDown();
    }
}
