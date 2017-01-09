package example.practise.design_pattern.simplefactory;

public class MinusOperator implements Operator {
    @Override
    public int getResult(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
