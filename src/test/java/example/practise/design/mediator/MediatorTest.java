package example.practise.design.mediator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MediatorTest {
    @Test
    public void shouldSendMessageThroughMediator() {
        //Given
        Mediator mediator = new Mediator();
        SystemClass systemOneClass = new SystemOneClass(mediator);
        SystemClass systemTwoClass = new SystemTwoClass(mediator);
        mediator.setSystemOne(systemOneClass);
        mediator.setSystemTwo(systemTwoClass);

        //When
        systemOneClass.sendMessage("hello");
        systemTwoClass.sendMessage("world");

        //Then
        assertThat(systemOneClass.getMessage(), is("world"));
        assertThat(systemTwoClass.getMessage(), is("hello"));
    }
}
