package example.practise.design.validatestrategy.facade;

import example.practise.design.validatestrategy.strategies.ValidateContext;
import example.practise.design.validatestrategy.validateobjects.ValidateObject;
import example.practise.design.validatestrategy.strategies.OtherValidateStrategy;

import java.util.List;

public class RealObjectAgainValidateFacade implements ValidateFacade {

    @Override
    public List<String> validate(ValidateObject validateObject) {
        ValidateContext validateContext = new ValidateContext();
        validateContext.addValidateStrategy(new OtherValidateStrategy());
        return validateContext.validate(validateObject);
    }
}
