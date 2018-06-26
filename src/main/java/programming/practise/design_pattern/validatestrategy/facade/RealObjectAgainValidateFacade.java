package programming.practise.design_pattern.validatestrategy.facade;

import programming.practise.design_pattern.validatestrategy.strategies.ValidateContext;
import programming.practise.design_pattern.validatestrategy.strategies.OtherValidateStrategy;

import java.util.List;

public class RealObjectAgainValidateFacade implements ValidateFacade {

    @Override
    public List<String> validate(Object validateObject) {
        ValidateContext validateContext = new ValidateContext();
        validateContext.addValidateStrategy(new OtherValidateStrategy());
        return validateContext.validate(validateObject);
    }
}
