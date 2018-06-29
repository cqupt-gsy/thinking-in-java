package programming.practise.concurrency.method;

public class JoinMethod {

    static class JoinThread implements Runnable {

        private final String name;
        private final Thread thread;

        public JoinThread(String name, Thread thread) {
            this.name = name;
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                if (thread != null) {
                    thread.join();
                }
                System.out.println(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String args[]) throws InterruptedException {
        Thread thread3 = new Thread(new JoinThread("A", null));
        Thread thread2 = new Thread(new JoinThread("B", thread3));
        Thread thread1 = new Thread(new JoinThread("C", thread2));

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
