package programming.practise.concurrency.keywords;

public class Volatile implements Runnable{

    //保证其他线程改变该变量时，也可以看到该变量的最新值
    private volatile boolean stop = true;

    //只适合多度单写，并且读线程只能监控某种状态
    private volatile int content = 0;


    @Override
    public void run() {
        while (stop) {
        }
    }

    public void stopRunning() {
        this.stop = false;
    }

    public void setNewContent(int value) {
        this.content = value;
    }

    public static void main(String args[]) throws InterruptedException {
        System.out.println("starting...");
        final Volatile target = new Volatile();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                target.setNewContent(i);
            }
        }).start();

        new Thread(() -> {
            while (target.stop) {
                System.out.println("current value: " + target.content);
            }
        }).start();
        Thread.sleep(10);
        target.stopRunning();
    }
}
