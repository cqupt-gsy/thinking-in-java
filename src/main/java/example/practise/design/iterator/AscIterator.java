package example.practise.design.iterator;

public class AscIterator implements Iterator {

    private int index;
    private AggregateObject aggregateObject;

    public AscIterator(AggregateObject aggregateObject) {
        this.aggregateObject = aggregateObject;
        index = -1;
    }

    @Override
    public boolean hasNext() {
        return index < aggregateObject.getValues().size() - 1;
    }

    @Override
    public String next() {
        return aggregateObject.getValues().get(++index);
    }
}
