package example.practise.design.iterator;

import java.util.ArrayList;
import java.util.List;

public class AggregateObject {

    private List<String> values;

    public AggregateObject() {
        values = new ArrayList<>();
    }

    public void append(String value) {
        this.values.add(value);
    }

    public Iterator createAscIterator() {
        return new AscIterator(this);
    }

    public List<String> getValues() {
        return values;
    }

    public Iterator createDescIterator() {
        return new DescIterator(this);
    }
}
