package example.practise.design.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorTest {

    @Test
    public void shouldReturnAscListValueWhenIteratorAggregateObject() {
        //Given
        AggregateObject aggregateObject = new AggregateObject();
        aggregateObject.append("hello");
        aggregateObject.append("world!");
        Iterator iterator = aggregateObject.createAscIterator();

        //When
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }

        //Then
        assertThat(builder.toString(), is("helloworld!"));
    }

    @Test
    public void shouldReturnDescListValueWhenIteratorAggregateObject() {
        //Given
        AggregateObject aggregateObject = new AggregateObject();
        aggregateObject.append("hello");
        aggregateObject.append("world!");
        Iterator iterator = aggregateObject.createDescIterator();

        //When
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }

        //Then
        assertThat(builder.toString(), is("world!hello"));
    }
}
