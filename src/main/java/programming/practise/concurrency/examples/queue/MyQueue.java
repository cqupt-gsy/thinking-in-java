package programming.practise.concurrency.examples.queue;

public interface MyQueue {
    /*
    * 有界阻塞对列：take，put操作在队列满和队列空时会阻塞，直到对应的时间发生
    * 有界非阻塞队列：offer，poll操作在队列满和队列空时直接返回
    * 无界阻塞队列：严格意义上是不存在阻塞的（队列大小为整形最大值），take，put操作在队列满和队列空时会阻塞
    * 无界无阻塞队列：offer，poll操作在队列满和队列空时直接返回
    * */

    String poll();

    boolean offer(String value);

    String take() throws InterruptedException;

    void put(String value) throws InterruptedException;
}
