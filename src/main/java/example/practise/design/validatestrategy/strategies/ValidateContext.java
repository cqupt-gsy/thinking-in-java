package example.practise.design.validatestrategy.strategies;

import example.practise.design.validatestrategy.validateobjects.ValidateObject;

import java.util.ArrayList;
import java.util.List;

public class ValidateContext {
    private List<ValidateStrategy> validateStrategies;
    private List<String> errorList;

    public ValidateContext() {
        this.validateStrategies = new ArrayList<>();
        this.errorList = new ArrayList<>();
    }

    public void addValidateStrategy(ValidateStrategy strategy) {
        validateStrategies.add(strategy);
    }

    public List<String> validate(ValidateObject validateObject) {
        validateStrategies.forEach(validateStrategy -> validateStrategy.validation(errorList, validateObject));
        return errorList;
    }
}
