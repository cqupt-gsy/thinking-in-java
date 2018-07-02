package programming.practise.concurrency.examples.queue;

public class UnboundBlockQueueWithSync extends BoundBlockQueueWithSync {

    public UnboundBlockQueueWithSync() {
        this(Integer.MAX_VALUE);
    }

    private UnboundBlockQueueWithSync(int size) {
        super(size);
    }
}
