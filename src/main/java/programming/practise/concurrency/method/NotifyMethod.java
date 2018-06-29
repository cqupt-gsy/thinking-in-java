package programming.practise.concurrency.method;

public class NotifyMethod {

    static class Notifier implements Runnable {

        private Object lock;

        public Notifier(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (!go) {
                    System.out.println(Thread.currentThread()
                            + " is going to notify all or one thread waiting on this object");
                    go = true;
                    System.out.println(Thread.currentThread()
                            + " change go to: " + go);
//                    lock.notify();
                    lock.notifyAll();
                }
            }
            System.out.println(Thread.currentThread() + " finished Execution");

        }
    }

    static class Waiter implements Runnable {

        private Object lock;

        public Waiter(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (!go) {
                    System.out.println(Thread.currentThread()
                            + " is going to wait on this object");
                    try {
                        lock.wait();
                    System.out.println(Thread.currentThread()
                                + "new value of go: " + go);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " is woken up");
                }
                go = true;
            }
            System.out.println(Thread.currentThread() + " finished Execution");

        }
    }
    volatile static boolean go = false;
    public static void main(String args[]) throws InterruptedException {

        Object lock = new Object();
        final Thread waiter1 = new Thread(new Waiter(lock));
        final Thread waiter2 = new Thread(new Waiter(lock));
        final Thread waiter3 = new Thread(new Waiter(lock));

        final Thread notifier = new Thread(new Notifier(lock));

        waiter1.start();
        waiter2.start();
        waiter3.start();


        Thread.sleep(100);

        notifier.start();
    }

}
