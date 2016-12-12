package example.practise.design.validatestrategy.facade;

import example.practise.design.validatestrategy.strategies.ValidateContext;
import example.practise.design.validatestrategy.strategies.ApplicationValidateStrategy;
import example.practise.design.validatestrategy.strategies.DobValidateStrategy;

import java.util.List;

public class RealObjectValidateFacade implements ValidateFacade {

    @Override
    public List<String> validate(Object validateObject) {
        ValidateContext validateContext = new ValidateContext();
        validateContext.addValidateStrategy(new ApplicationValidateStrategy());
        validateContext.addValidateStrategy(new DobValidateStrategy());
        return validateContext.validate(validateObject);
    }
}
