package example.practise.design.iterator;

public class DescIterator implements Iterator {
    private int index;
    private AggregateObject aggregateObject;

    public DescIterator(AggregateObject aggregateObject) {
        this.aggregateObject = aggregateObject;
        index = this.aggregateObject.getValues().size();
    }

    @Override
    public boolean hasNext() {
        return index > 0;
    }

    @Override
    public String next() {
        return this.aggregateObject.getValues().get(--index);
    }
}
