package programming.practise.concurrency.examples.queue;

public class UnboundUnblockQueueWithLock extends BoundUnblockQueueWithLock {

    public UnboundUnblockQueueWithLock() {
        this(Integer.MAX_VALUE);
    }

    private UnboundUnblockQueueWithLock(int size) {
        super(size);
    }
}
