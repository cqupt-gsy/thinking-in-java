package example.practise.design.simplefactory;

public class Calculator {


    public int getResults(int firstNumber, int secondNumber, String operatorSimble) {

        Operator operator = Operator.Operators.get(operatorSimble);

        return operator.getResult(firstNumber, secondNumber);
    }
}
