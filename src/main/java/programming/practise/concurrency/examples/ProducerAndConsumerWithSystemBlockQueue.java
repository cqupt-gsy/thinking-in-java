package programming.practise.concurrency.examples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumerWithSystemBlockQueue {

    static class Producer implements Runnable {

        private volatile boolean stop = false;
        private volatile int count = 1;
        private final BlockingQueue<String> sharedList;

        public Producer(BlockingQueue<String> sharedList) {
            this.sharedList = sharedList;
        }

        @Override
        public void run() {

            while (!stop) {
                System.out.println(Thread.currentThread().getName() + ": Producing item: " + count);
                sharedList.offer(Thread.currentThread().getName() + ": Produce item: " + count++);
            }
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }
    }

    static class Consumer implements Runnable {

        private volatile boolean stop = false;

        private final BlockingQueue<String> sharedList;

        public Consumer(BlockingQueue<String> sharedList) {
            this.sharedList = sharedList;
        }

        @Override
        public void run() {
            while (!stop) {
                final String poll = sharedList.poll();
                if (poll == null) {
                    continue;
                }
                System.out.println(Thread.currentThread().getName() + ": Consuming item: " + poll);
            }
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }
    }

    public static void main(String args[]) throws InterruptedException {
        BlockingQueue<String> sharedList = new ArrayBlockingQueue<>(10);
        final Producer producer1 = new Producer(sharedList);
        final Producer producer2 = new Producer(sharedList);
        final Producer producer3 = new Producer(sharedList);
        final Consumer consumer1 = new Consumer(sharedList);
        final Consumer consumer2 = new Consumer(sharedList);
        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

        Thread.sleep(2);
        producer1.setStop(true);
        producer2.setStop(true);
        producer3.setStop(true);
        consumer1.setStop(true);
        consumer2.setStop(true);
    }

}
