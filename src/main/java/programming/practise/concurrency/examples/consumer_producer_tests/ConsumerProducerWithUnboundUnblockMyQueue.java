package programming.practise.concurrency.examples.consumer_producer_tests;

import programming.practise.concurrency.examples.consumer.ConsumerMyQueueUnblock;
import programming.practise.concurrency.examples.producer.ProducerMyQueueUnblock;
import programming.practise.concurrency.examples.queue.UnboundUnblockQueueWithLock;

import java.util.concurrent.CountDownLatch;

public class ConsumerProducerWithUnboundUnblockMyQueue {

    static final int PRODUCER_NUMBER = 3;
    static final int CONSUMER_NUMBER = 2;

    public static void main(String args[]) {
        CountDownLatch countDownLatch = new CountDownLatch(PRODUCER_NUMBER);
        UnboundUnblockQueueWithLock queue = new UnboundUnblockQueueWithLock();
//        UnboundUnblockQueueWithSync queue = new UnboundUnblockQueueWithSync();
        for (int i = 1; i <= PRODUCER_NUMBER; i++) {
            new Thread(new ProducerMyQueueUnblock(queue, countDownLatch), "P"+i).start();
        }
        new Thread(() -> {
            try {
                countDownLatch.await();
                queue.offer("END");
                System.out.println("ADD END TASK");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (int i = 1; i <= CONSUMER_NUMBER; i++) {
            new Thread(new ConsumerMyQueueUnblock(queue), "C"+i).start();
        }
    }
}
