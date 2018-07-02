package programming.practise.concurrency.classes;

import java.util.concurrent.*;

public class FutureTaskExample {

    //todo 在总结完线程池后需要加强线程池的各种方法使用
    public static void main(String args[]) throws ExecutionException, InterruptedException {

        ExecutorService executors = Executors.newSingleThreadExecutor();
        final Future<String> submit = executors.submit(() -> {
            Thread.sleep(3000);
            return "hello world";
        });
        executors.shutdown();
        System.out.println("result: " + submit.get());
        System.out.println("result: " + submit.get());
        System.out.println("finished");
    }
}
