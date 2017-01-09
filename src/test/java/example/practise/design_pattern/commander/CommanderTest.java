package example.practise.design_pattern.commander;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CommanderTest {

    @Test
    public void shouldReceiverExecuteCommanderWhenInvokerExecuteCommander() {
        //Given
        ChiefReceiver chiefReceiver = mock(ChiefReceiver.class);
        WaiterReceiver waiterReceiver = mock(WaiterReceiver.class);
        CookCommander cookCommander = new CookCommander(chiefReceiver);
        OrderCommander orderCommander = new OrderCommander(waiterReceiver);
        Invoker invoker = new Invoker();
        invoker.addCommander(orderCommander);
        invoker.addCommander(cookCommander);

        //When
        invoker.executeCommander();

        //Then
        verify(waiterReceiver, times(1)).action();
        verify(chiefReceiver, times(1)).action();
    }
}
