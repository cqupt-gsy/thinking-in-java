package programming.practise.concurrency.examples.consumer;

import programming.practise.concurrency.examples.queue.MyQueue;

public class ConsumerMyQueueBlock implements Runnable {

    private MyQueue sharedQueue;

    public ConsumerMyQueueBlock(MyQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final long startTime = System.currentTimeMillis();
                final String task = sharedQueue.take();
                final long endTime = System.currentTimeMillis();
                if ("END".equals(task)) {
                    sharedQueue.put(task);
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
