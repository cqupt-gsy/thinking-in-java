package programming.practise.concurrency.examples;

import java.util.ArrayList;
import java.util.List;

public class BlockQueueExample {

    private int size;
    private final List<Integer> arrays = new ArrayList<>();

    public BlockQueueExample(int size) {
        this.size = size;
    }

    public void offer(int value) throws InterruptedException {
        synchronized (this) {
            if (arrays.size() == size) {
                System.out.println("Queue is full, need to consuming!");
                wait();
            }
            arrays.add(value);
            notify();
        }
    }

    public int poll() throws InterruptedException {
        synchronized (this) {
            if (arrays.isEmpty()) {
                System.out.println("Queue is empty, need to producing!");
                wait();
            }
            notify();
            return arrays.remove(0);
        }
    }

    public static void main(String args[]) {
        BlockQueueExample blockQueue = new BlockQueueExample(100);

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + " producing: " + i);
                    blockQueue.offer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            int value;
            try {
                while ((value = blockQueue.poll()) != 9999) {
                    System.out.println(Thread.currentThread().getName() + " consuming: " + value);
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
