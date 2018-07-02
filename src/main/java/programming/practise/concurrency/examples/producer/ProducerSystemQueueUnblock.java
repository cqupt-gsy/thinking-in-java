package programming.practise.concurrency.examples.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ProducerSystemQueueUnblock implements Runnable {

    private BlockingQueue<String> sharedQueue;
    private CountDownLatch countDownLatch;

    public ProducerSystemQueueUnblock(BlockingQueue<String> sharedQueue, CountDownLatch countDownLatch) {
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
