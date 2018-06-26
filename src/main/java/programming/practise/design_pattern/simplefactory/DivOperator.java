package programming.practise.design_pattern.simplefactory;

public class DivOperator implements Operator {
    @Override
    public int getResult(int firstNumber, int secondNumber) {
        if (secondNumber == 0){
            throw new IllegalArgumentException("The second number can not be zero");
        }
        return firstNumber / secondNumber;
    }
}
