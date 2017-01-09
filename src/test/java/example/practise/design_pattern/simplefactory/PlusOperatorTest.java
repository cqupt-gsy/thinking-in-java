package example.practise.design_pattern.simplefactory;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlusOperatorTest {
    @Test
    public void shouldReturnTwoWhenOnePlusOne() {
        //Given
        Operator operator = new PlusOperator();

        //When
        int result = operator.getResult(1, 1);

        //Then
        assertThat(result, is(2));
    }
}
