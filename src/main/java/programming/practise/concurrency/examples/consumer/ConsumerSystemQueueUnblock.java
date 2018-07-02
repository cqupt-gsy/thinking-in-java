package programming.practise.concurrency.examples.consumer;

import java.util.concurrent.BlockingQueue;

public class ConsumerSystemQueueUnblock implements Runnable {

    private BlockingQueue<String> sharedQueue;

    public ConsumerSystemQueueUnblock(BlockingQueue<String> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final long startTime = System.currentTimeMillis();
                final String task = sharedQueue.poll();
                final long endTime = System.currentTimeMillis();
                if ("END".equals(task)) {
                    sharedQueue.offer(task);
                    break;
                } else if (task != null){
                    System.out.println(String.format("%s consuming [%s] within [%s]", Thread.currentThread().getName(), task, (endTime - startTime)));
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("%s consuming finished", Thread.currentThread().getName()));
    }
}
