package programming.practise.concurrency.examples.printer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {

    static class FileWriterRunnable implements Runnable {

        private FileWriterUtil fileWriterUtil;
        private final char value;
        private final int threadNumber;

        public FileWriterRunnable(FileWriterUtil fileWriterUtil, char value, int threadNumber) {
            this.fileWriterUtil = fileWriterUtil;
            this.value = value;
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            for (int index = 0; index < 16; index++) {
                synchronized (fileWriterUtil) {
                    while (threadNumber != fileWriterUtil.getCurrentThreadNumber()) {
                        try {
                            fileWriterUtil.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    fileWriterUtil.writeFile(value, threadNumber);
                    fileWriterUtil.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        final FileWriterUtil util = new FileWriterUtil();
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(new FileWriterRunnable(util, 'A', 1));
        service.execute(new FileWriterRunnable(util, 'B', 2));
        service.execute(new FileWriterRunnable(util, 'C', 3));
        service.execute(new FileWriterRunnable(util, 'D', 4));

        service.shutdown();

    }

}
