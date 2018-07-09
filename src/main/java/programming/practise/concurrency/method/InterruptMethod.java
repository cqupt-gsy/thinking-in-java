package programming.practise.concurrency.method;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InterruptMethod {

    static class Task implements Runnable {

        private BlockingQueue<String> queue;

        public Task(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        if (interrupted) {
                            break;
                        }
                        queue.take();
                        return;
                    } catch (InterruptedException e) {
                        interrupted = true;
                        System.out.println(Thread.currentThread().getName() + " interrupt, with state: " + Thread.currentThread().isInterrupted());
                    }
                }
            } finally {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " interrupt, with state: " + Thread.currentThread().isInterrupted());

            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        final Task target = new Task(queue);
        final Thread threadA = new Thread(target, "A");
        threadA.start();
        Thread.sleep(100);
        threadA.interrupt();
    }
}
