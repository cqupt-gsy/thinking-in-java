package programming.practise.concurrency.examples.consumer_producer_tests;

import programming.practise.concurrency.examples.consumer.ConsumerMyQueueBlock;
import programming.practise.concurrency.examples.producer.ProducerMyQueueBlock;
import programming.practise.concurrency.examples.queue.BoundBlockQueueWithSync;

import java.util.concurrent.CountDownLatch;

public class ConsumerProducerWithBoundBlockMyQueue {

  static final int PRODUCER_NUMBER = 3;
  static final int CONSUMER_NUMBER = 2;

  public static void main(String args[]) {
    CountDownLatch countDownLatch = new CountDownLatch(PRODUCER_NUMBER);
    //        BoundBlockQueueWithLock queue = new BoundBlockQueueWithLock(10);
    BoundBlockQueueWithSync queue = new BoundBlockQueueWithSync(10);
    for (int i = 1; i <= PRODUCER_NUMBER; i++) {
      new Thread(new ProducerMyQueueBlock(queue, countDownLatch), "P" + i).start();
    }
    new Thread(
            () -> {
              try {
                countDownLatch.await();
                queue.put("END");
                System.out.println("ADD END TASK");
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            })
        .start();
    for (int i = 1; i <= CONSUMER_NUMBER; i++) {
      new Thread(new ConsumerMyQueueBlock(queue), "C" + i).start();
    }
  }
}
