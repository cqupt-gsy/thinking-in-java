package example.practise.design.validatestrategy.strategies;

import java.util.List;

public interface ValidateStrategy {

    void validation(List<String> errorList, Object validateObject);
}
