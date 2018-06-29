package programming.practise.concurrency.examples;

import java.util.ArrayList;
import java.util.List;

public class ProducerAndConsumer {

    static class Producer implements Runnable {

        private volatile boolean stop = false;
        private final List<String> sharedList;

        public Producer(List<String> sharedList) {
            this.sharedList = sharedList;
        }

        @Override
        public void run() {
            int count = 1;
            while (!stop) {
                synchronized (sharedList) {
                    if (sharedList.size() == 10) {
                        try {
                            System.out.println("List is full, waiting consumer to unlock, current size: " + sharedList.size());
                            sharedList.wait();
                            count = 1;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("Producing item: " + count);
                    sharedList.add("Produce item: " + count++);
                    sharedList.notify();
                }
            }
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }
    }

    static class Consumer implements Runnable {

        private volatile boolean stop = false;

        private final List<String> sharedList;

        public Consumer(List<String> sharedList) {
            this.sharedList = sharedList;
        }

        @Override
        public void run() {
            while (!stop) {
                synchronized (sharedList) {
                    if (sharedList.isEmpty()) {
                        try {
                            System.out.println("List is empty, waiting producer to unlock");
                            sharedList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Consuming item: " + sharedList.remove(0));
                    sharedList.notify();
                }
            }
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }
    }

    public static void main(String args[]) throws InterruptedException {
        List<String> sharedList = new ArrayList<>();
        final Producer producer = new Producer(sharedList);
        final Consumer consumer = new Consumer(sharedList);
        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(2);
        producer.setStop(true);
        consumer.setStop(true);
    }

}
