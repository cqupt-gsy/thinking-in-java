package programming.practise.concurrency.examples;

import java.util.ArrayList;
import java.util.List;

public class BlockQueueExample {

    private volatile int size;
    private List<Integer> arrays = new ArrayList<>();

    public BlockQueueExample(int size) {
        this.size = size;
    }

    public void offer(int value) throws InterruptedException {
        synchronized (arrays) {
            if (arrays.size() == size) {
                System.out.println("Queue is full, need to consuming!");
                arrays.wait();
            }
            arrays.add(value);
            arrays.notify();
        }
    }

    public int poll() throws InterruptedException {
        synchronized (arrays) {
            if (arrays.isEmpty()) {
                System.out.println("Queue is empty, need to producing!");
                arrays.wait();
            } else {
                arrays.notify();
            }
            return arrays.remove(0);
        }
    }

    public static void main(String args[]) {
        BlockQueueExample blockQueue = new BlockQueueExample(100);

        new Thread(() -> {
            int value = 0;
            try {
                while (value++ < 50) {
                    System.out.println(Thread.currentThread().getName() + " consuming: " + blockQueue.poll());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            int value = 0;
            try {
                while (value++ < 50) {
                    System.out.println(Thread.currentThread().getName() + " consuming: " + blockQueue.poll());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    blockQueue.offer(i);
                    System.out.println(Thread.currentThread().getName() + " producing: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    blockQueue.offer(i);
                    System.out.println(Thread.currentThread().getName() + " producing: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
