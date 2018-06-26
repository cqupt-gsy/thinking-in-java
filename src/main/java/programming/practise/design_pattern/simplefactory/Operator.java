package programming.practise.design_pattern.simplefactory;

import java.util.HashMap;
import java.util.Map;

public interface Operator {

    Map<String, Operator> Operators = new HashMap<String, Operator>(){{
        put("+", new PlusOperator());
        put("-", new MinusOperator());
        put("*", new MultiOperator());
        put("/", new DivOperator());
    }};

    int getResult(int firstNumber, int secondNumber);
}
