package programming.practise.concurrency.classes;

import java.util.concurrent.*;

public class CompletionServiceExample {

    //CompletionService本质就是讲Executor和BlockQueue封装在一起
    //不需要自己去循环遍历get操作，所有的task完成后会放入阻塞队列
    //因此阻塞的点在take操作，get操作永远不会阻塞了
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        CompletionService<String> service = new ExecutorCompletionService<>(Executors.newFixedThreadPool(5));
        for (int index = 0; index < 10; index++) {
            int finalIndex = index;
            service.submit(() -> {
                Thread.sleep(1000);
                return "hello: " + (finalIndex + 1);
            });

        }
        Future<String> resultFuture;
        while ((resultFuture = service.take()) != null) {
            long startTime = System.currentTimeMillis();
            final String result = resultFuture.get();
            long endTime = System.currentTimeMillis();
            System.out.println("Get time: " + (endTime - startTime));
        }
    }
}
