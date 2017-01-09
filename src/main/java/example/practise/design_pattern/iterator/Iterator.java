package example.practise.design_pattern.iterator;

public interface Iterator {
    boolean hasNext();

    String next() throws IllegalAccessException;
}
