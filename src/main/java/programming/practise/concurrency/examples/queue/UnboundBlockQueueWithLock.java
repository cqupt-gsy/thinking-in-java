package programming.practise.concurrency.examples.queue;

public class UnboundBlockQueueWithLock extends BoundBlockQueueWithLock {

    public UnboundBlockQueueWithLock() {
        this(Integer.MAX_VALUE);
    }

    private UnboundBlockQueueWithLock(int size) {
        super(size);
    }
}
