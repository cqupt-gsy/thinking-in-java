package example.practise.design.memento;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MementoTest {

    @Test
    public void shouldReturnOldValueOfOriginator() {
        //Given
        Originator originator = new Originator(5);
        CareTaker careTaker = new CareTaker(originator.createMemento());
        originator.changeNewValue(10);

        //When
        originator.rollback(careTaker.getMemento());

        //Then
        assertThat(originator.getOriginalValue(), is(5));
    }
}
