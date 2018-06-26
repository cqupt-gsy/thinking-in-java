package programming.practise.design_pattern.iterator;

import java.lang.reflect.Field;

public class AscIterator implements Iterator {

    private int currentIndex;
    private Object aggregateObject;
    private Field[] fields;

    public AscIterator(Object object) {
        this.aggregateObject = object;
        fields = object.getClass().getDeclaredFields();
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
