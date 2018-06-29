package programming.practise.concurrency.classes;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final Lock lock = new ReentrantLock();
    private int count = 0;

    public int addCount() {
        lock.lock();
        try {
            return count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String args[]) {
        ReentrantLockExample example = new ReentrantLockExample();


        new Thread(() -> {
            int count;
            while ((count = example.addCount()) < 10) {
                System.out.println(Thread.currentThread().getName() + ": add count to " + count);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": exit!");
        }).start();

        new Thread(() -> {
            int count;
            while ((count = example.addCount()) < 10) {
                System.out.println(Thread.currentThread().getName() + ": add count to " + count);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": exit!");
        }).start();
    }

}
