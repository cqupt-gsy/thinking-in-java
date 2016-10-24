package example.practise.design.simplefactory;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculator;
    private int firstNumber;
    private int secondNumber;
    private String operatorSimble;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void shouldReturnTwoWhenOnePlusOne() {
        //Given
        initalNumberAndOperator(1, 1, "+");

        //When
        int result = calculator.getResults(firstNumber, secondNumber, operatorSimble);

        //Then
        assertThat(result, is(2));
    }


    @Test
    public void shouldReturnThreeWhenOnePlusTwo() {
        //Given
        initalNumberAndOperator(1, 2, "+");

        //When
        int result = calculator.getResults(firstNumber, secondNumber, operatorSimble);

        //Then
        assertThat(result, is(3));
    }

    @Test
    public void shouldReturnOneWhenTwoMinusOne() {
        //Given
        initalNumberAndOperator(2, 1, "-");

        //When
        int result = calculator.getResults(firstNumber, secondNumber, operatorSimble);

        //Then
        assertThat(result, is(1));
    }

    @Test
    public void shouldReturnFourWhenTwoMutiplyTwo() {
        //Given
        initalNumberAndOperator(2, 2, "*");

        //When
        int result = calculator.getResults(firstNumber, secondNumber, operatorSimble);

        //Then
        assertThat(result, is(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExcepetionWhenSecondNumberIsZeor() {
        //Given
        initalNumberAndOperator(2, 0, "/");

        //When
        calculator.getResults(firstNumber, secondNumber, operatorSimble);

        //Then
    }

    @Test
    public void shouldReturnTwoWhenFourDivTwo() {
        //Given
        initalNumberAndOperator(4, 2, "/");

        //When
        int result =calculator.getResults(firstNumber, secondNumber,operatorSimble);

        //Then
        assertThat(result, is(2));


    }

    private void initalNumberAndOperator(int firstNumber, int secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorSimble = operator;
    }
}
