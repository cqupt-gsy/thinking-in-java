package programming.practise.concurrency.examples.consumer_producer_tests;

import programming.practise.concurrency.examples.consumer.ConsumerMyQueueBlock;
import programming.practise.concurrency.examples.producer.ProducerMyQueueBlock;
import programming.practise.concurrency.examples.queue.UnboundBlockQueueWithLock;

import java.util.concurrent.CountDownLatch;

public class ConsumerProducerWithUnboundBlockMyQueue {

    static final int PRODUCER_NUMBER = 3;
    static final int CONSUMER_NUMBER = 2;

    public static void main(String args[]) {
        CountDownLatch countDownLatch = new CountDownLatch(PRODUCER_NUMBER);
        UnboundBlockQueueWithLock queue = new UnboundBlockQueueWithLock();
//        UnboundBlockQueueWithSync queue = new UnboundBlockQueueWithSync();
        for (int i = 1; i <= PRODUCER_NUMBER; i++) {
            new Thread(new ProducerMyQueueBlock(queue, countDownLatch), "P"+i).start();
        }
        new Thread(() -> {
            try {
                countDownLatch.await();
                queue.put("END");
                System.out.println("ADD END TASK");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (int i = 1; i <= CONSUMER_NUMBER; i++) {
            new Thread(new ConsumerMyQueueBlock(queue), "C"+i).start();
        }
    }
}
