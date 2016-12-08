package example.practise.design.validatestrategy.strategies;

import example.practise.design.validatestrategy.validateobjects.ValidateObject;

import java.util.List;

public interface ValidateStrategy {

    void validation(List<String> errorList, ValidateObject validateObject);
}
