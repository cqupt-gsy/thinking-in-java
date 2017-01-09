package example.practise.design_pattern.iterator;

import java.lang.reflect.Field;

public class DescIterator implements Iterator {
    private final Field[] fields;
    private int currentIndex;
    private Object aggregateObject;

    public DescIterator(Object object) {
        this.aggregateObject = object;
        fields = object.getClass().getDeclaredFields();
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
