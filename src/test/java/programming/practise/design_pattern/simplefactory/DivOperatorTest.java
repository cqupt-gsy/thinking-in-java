package programming.practise.design_pattern.simplefactory;

import org.junit.Test;

public class DivOperatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSencondNumberIsZero() {
        //Given
        Operator operator = new DivOperator();

        //When
        operator.getResult(2, 0);

        //Then


    }
}
