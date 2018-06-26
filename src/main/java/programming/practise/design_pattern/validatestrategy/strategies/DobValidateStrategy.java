package programming.practise.design_pattern.validatestrategy.strategies;

import java.util.List;

public class DobValidateStrategy implements ValidateStrategy {


    @Override
    public void validation(List<String> errorList, Object validateObject) {
        errorList.add("dob errors");
//        validateObject.getDateOfBirth();
    }
}
