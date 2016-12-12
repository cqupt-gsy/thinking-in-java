package example.practise.design.validatestrategy.strategies;

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

    public List<String> validate(Object validateObject) {
        validateStrategies.forEach(validateStrategy -> validateStrategy.validation(errorList, validateObject));
        return errorList;
    }
}
