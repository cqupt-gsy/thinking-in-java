package programming.practise.design_pattern.simplefactory;

public class MultiOperator implements Operator {
    @Override
    public int getResult(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
