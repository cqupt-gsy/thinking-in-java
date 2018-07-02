package programming.practise.concurrency.classes;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Integer>{

    //阈值
    private static final int THRESHOLD = 10;
    //起始值
    private int start;
    //结束值
    private int end;

    public ForkJoinExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        boolean compute = (end - start) <= THRESHOLD;
        int res = 0;
        if (compute){
            for (int i = start; i <= end; i++){
                res += i;
            }
        }else {
            //如果长度大于阈值，则分割为小任务
            int mid = (start + end) / 2;
            ForkJoinExample task1 = new ForkJoinExample(start,mid);
            ForkJoinExample task2 = new ForkJoinExample(mid + 1, end);
            //计算小任务的值
            task1.fork();
            task2.fork();
            //得到两个小任务的值
            int task1Res = task1.join();
            int task2Res = task2.join();
            res = task1Res + task2Res;
        }
        return res;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinExample task = new ForkJoinExample(1,100);
        ForkJoinTask<Integer> submit = pool.submit(task);
        System.out.println("Final result:" + submit.get());
    }
    /*
    * 工作窃取算法作为支撑，自己队列任务完成后回去其他线程的队列中拿任务执行
    * RecursiveAction和RecursiveTask，其中，前者主要处理没有返回结果的任务，后者主要处理有返回结果的任务。
    * 主要的核心思想就是把超大的计算拆分为小的计算，通俗来说就是把一个极大的任务拆分为很多个小任务
    * 在fork方法中，它会先判断当前的线程是否属于ForkJoinWorkerThread线程，如果属于这个线程，那么就把线程添加到workQueue中，否则就直接执行这个任务
    * 在join的操作主要是判断当前任务的执行状态和返回结果，任务状态有四种：已完成（NORMAL），被取消（CANCELLED），信号（SIGNAL）和出现异常（EXCEPTIONAL）
    *
    * */
}
