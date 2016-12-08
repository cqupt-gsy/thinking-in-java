package example.practise.design.validatestrategy;

import java.util.List;

public class RealObjectValidateFacade implements ValidateFacade {

    @Override
    public List<String> validate(ValidateObject validateObject) {
        ValidateContext validateContext = new ValidateContext();
        validateContext.addValidateStrategy(new ApplicationValidateStrategy());
        validateContext.addValidateStrategy(new DobValidateStrategy());
        return validateContext.validate(validateObject);
    }
}
