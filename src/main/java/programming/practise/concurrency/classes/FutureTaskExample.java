package programming.practise.concurrency.classes;

import java.util.concurrent.*;

public class FutureTaskExample {

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        ExecutorService executors = Executors.newSingleThreadExecutor();
        System.out.println("is shut down: " + executors.isShutdown());
        System.out.println("is terminate: " + executors.isTerminated());
        final Future<String> submit = executors.submit(() -> {
            Thread.sleep(3000);
            return "hello world";
        });
        executors.shutdown();//一定要关闭线程池，否则JVM无法退出
        System.out.println("is shut down: " + executors.isShutdown());
        System.out.println("is terminate: " + executors.isTerminated());
        executors.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("result: " + submit.get());
        System.out.println("result: " + submit.get());
        System.out.println("is terminate: " + executors.isTerminated());
        System.out.println("finished");
    }
}
