package threads.delegation;

public class ThreadTest{
    private Test[] replayers;

    public void start() {
        replayers = new Test[2];
        for (int i = 0; i < replayers.length; ++i) {
            replayers[i] = new Test();
        }
        for (int i = 0; i < replayers.length; ++i) {
            new Thread(replayers[i]).start();
        }
    }


    class Test implements Runnable {
        private int now = 0;
        @Override
        public void run() {
            while (now < 10) {
                System.out.println("NOW VALUE [" + now++ + "]");
            }
        }

    }
}
