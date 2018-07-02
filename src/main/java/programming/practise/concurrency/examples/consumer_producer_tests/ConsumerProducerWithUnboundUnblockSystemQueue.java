package programming.practise.concurrency.examples.consumer_producer_tests;

import programming.practise.concurrency.examples.consumer.ConsumerSystemQueueUnblock;
import programming.practise.concurrency.examples.producer.ProducerSystemQueueUnblock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducerWithUnboundUnblockSystemQueue {

    static final int PRODUCER_NUMBER = 3;
    static final int CONSUMER_NUMBER = 2;

    public static void main(String args[]) {
        CountDownLatch countDownLatch = new CountDownLatch(PRODUCER_NUMBER);
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        for (int i = 1; i <= PRODUCER_NUMBER; i++) {
            new Thread(new ProducerSystemQueueUnblock(queue, countDownLatch), "P"+i).start();
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
            new Thread(new ConsumerSystemQueueUnblock(queue), "C"+i).start();
        }
    }
}
