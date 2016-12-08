package example.practise.design.validatestrategy;

import java.util.List;

public class RealObjectAgainValidateFacade implements ValidateFacade{

    @Override
    public List<String> validate(ValidateObject validateObject) {
        ValidateContext validateContext = new ValidateContext();
        validateContext.addValidateStrategy(new OtherValidateStrategy());
        return validateContext.validate(validateObject);
    }
}
