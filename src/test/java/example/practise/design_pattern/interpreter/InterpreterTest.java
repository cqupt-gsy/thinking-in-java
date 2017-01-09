package example.practise.design_pattern.interpreter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class InterpreterTest {
    @Test
    public void shouldInterpreterExpressionBeSequence() {
        //Given
        List<Interpreter> interpreters = new ArrayList<>();
        Interpreter firstInterpreter = mock(FirstInterpreter.class);
        Interpreter secondInterpreter = mock(SecondInterpreter.class);
        interpreters.add(firstInterpreter);
        interpreters.add(secondInterpreter);
        Context context = new Context();

        //When
        interpreters.forEach(interpreter -> interpreter.interpret(context));

        //Then
        verify(firstInterpreter, times(1)).interpret(context);
        verify(secondInterpreter, times(1)).interpret(context);

    }
}
