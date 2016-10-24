package example.practise.design.simplefactory;

public class PlusOperator implements Operator {

    @Override
    public int getResult(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
