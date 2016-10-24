package example.practise.design.simplefactory;

public class MinusOperator implements Operator {
    @Override
    public int getResult(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
