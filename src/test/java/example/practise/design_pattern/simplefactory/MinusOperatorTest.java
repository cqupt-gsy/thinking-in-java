package example.practise.design_pattern.simplefactory;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MinusOperatorTest {
    @Test
    public void shouldReturnOneWhenTwoMinusOne() {
        //Given
        Operator operator = new MinusOperator();

        //When
        int result =operator.getResult(2, 1);

        //Then
        assertThat(result, is(1));

    }
}
