package example.practise.design.iterator;

import java.lang.reflect.Field;

public class DescIterator implements Iterator {
    private final Field[] fields;
    private int currentIndex;
    private AggregateObject aggregateObject;

    public DescIterator(AggregateObject aggregateObject) {
        this.aggregateObject = aggregateObject;
        fields = aggregateObject.getClass().getDeclaredFields();
        currentIndex = fields.length ;
    }

    @Override
    public boolean hasNext() {
        --currentIndex;
        return currentIndex >= 0;
    }

    @Override
    public String next() throws IllegalAccessException {
        fields[currentIndex].setAccessible(true);
        return fields[currentIndex].get(aggregateObject).toString();
    }
}
