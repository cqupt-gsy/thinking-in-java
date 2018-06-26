package programming.practise.design_pattern.simplefactory;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MultiOperatorTest {
    @Test
    public void shouldReturnFourWhenTwoMultiTwo() {
        //Given
        Operator operator = new MultiOperator();

        //When
        int result = operator.getResult(2, 2);

        //Then
        assertThat(result, is(4));

    }
}
