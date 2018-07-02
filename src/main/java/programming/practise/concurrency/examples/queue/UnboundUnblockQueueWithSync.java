package programming.practise.concurrency.examples.queue;

public class UnboundUnblockQueueWithSync extends BoundUnblockQueueWithSync {

    public UnboundUnblockQueueWithSync() {
        this(Integer.MAX_VALUE);
    }

    private UnboundUnblockQueueWithSync(int size) {
        super(size);
    }
}
