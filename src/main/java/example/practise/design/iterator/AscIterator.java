package example.practise.design.iterator;

import java.lang.reflect.Field;

public class AscIterator implements Iterator {

    private int currentIndex;
    private AggregateObject aggregateObject;
    private Field[] fields;

    public AscIterator(AggregateObject aggregateObject) {
        this.aggregateObject = aggregateObject;
        fields = aggregateObject.getClass().getDeclaredFields();
        currentIndex = -1;
    }

    @Override
    public boolean hasNext() {
        ++currentIndex;
        return currentIndex < aggregateObject.getClass().getDeclaredFields().length;
    }

    @Override
    public String next() throws IllegalAccessException {
        fields[currentIndex].setAccessible(true);
        return fields[currentIndex].get(aggregateObject).toString();
    }
}
