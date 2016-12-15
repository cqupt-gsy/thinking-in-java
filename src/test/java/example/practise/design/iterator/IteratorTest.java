package example.practise.design.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorTest {

    @Test
    public void shouldReturnAscListValueWhenIteratorAggregateObject() throws IllegalAccessException {
        //Given
        AggregateObject aggregateObject = new AggregateObject();
        aggregateObject.setFirstField("hello");
        aggregateObject.setSecondField("world");
        aggregateObject.setThirdField("!");
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
    public void shouldReturnDescListValueWhenIteratorAggregateObject() throws IllegalAccessException {
        //Given
        AggregateObject aggregateObject = new AggregateObject();
        aggregateObject.setFirstField("hello");
        aggregateObject.setSecondField("world");
        aggregateObject.setThirdField("!");
        Iterator iterator = aggregateObject.createDescIterator();

        //When
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }

        //Then
        assertThat(builder.toString(), is("!worldhello"));
    }
}
