package programming.practise.concurrency.classes;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    static class CoThreads implements Runnable {


        private CyclicBarrier cyclicBarrier;

        public CoThreads(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        //所有线程各自执行相关操作，然后在CyclicBarrier处等待所有线程完成对应的操作
        //CyclicBarrier需要指定有多少线程是协同合作的，也就是需要等待多少线程到达它的等待数量
        //当所有线程都达到CyclicBarrier的等待数量就会执行汇总方法
        //其他线程执行收尾方法
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("All parties are arrived at barrier, lets play"));
        new Thread(new CoThreads(cyclicBarrier)).start();
        new Thread(new CoThreads(cyclicBarrier)).start();
        new Thread(new CoThreads(cyclicBarrier)).start();
    }
}
