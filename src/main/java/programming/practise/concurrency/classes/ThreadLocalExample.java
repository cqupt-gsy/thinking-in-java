package programming.practise.concurrency.classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalExample {


    private static final ThreadLocal<SimpleDateFormat> dateFormatHolder = ThreadLocal.withInitial(() -> {
        System.out.println("Creating SimpleDateFormat for Thread : " + Thread.currentThread().getName());
        return new SimpleDateFormat("dd/MM/yyyy");
    });

    private static final ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> {
        System.out.println("Creating threadLocal for Thread : " + Thread.currentThread().getName());
        return Thread.currentThread().getName();
    });

    static class Task1 implements Runnable{

        @Override
        public void run() {
            for(int i=0; i<2; i++){
                System.out.println("Thread: " + Thread.currentThread().getName() + " Formatted Date: " + dateFormatHolder.get().format(new Date()));
            }
        }
    }

    static class Task2 implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName() + "======>" + threadLocal.get());

        }
    }

    public static void main(String args[]) {
        new Thread(new Task1()).start();
        new Thread(new Task1()).start();
        new Thread(new Task2()).start();
        new Thread(new Task2()).start();
    }

}
