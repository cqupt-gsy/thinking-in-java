package programming.practise.concurrency.classes;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    static class ExecutorTask implements Runnable {

        private CountDownLatch countDownLatch;

        public ExecutorTask(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": start execution");
            this.countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + ": stop execution");
        }
    }

    static class WaitingTask implements Runnable {

        private CountDownLatch countDownLatch;

        public WaitingTask(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": start waiting.");
                this.countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + ": stop waiting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new WaitingTask(countDownLatch)).start();
        new Thread(new WaitingTask(countDownLatch)).start();
        new Thread(new WaitingTask(countDownLatch)).start();
        new Thread(new ExecutorTask(countDownLatch)).start();
        new Thread(new ExecutorTask(countDownLatch)).start();
        new Thread(new ExecutorTask(countDownLatch)).start();
    }

}
