package example.practise.design.validatestrategy;

import java.util.List;

public interface ValidateStrategy {

    void validation(List<String> errorList, ValidateObject validateObject);
}
