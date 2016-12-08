package example.practise.design.validatestrategy;

import java.util.List;

public class DobValidateStrategy implements ValidateStrategy {


    @Override
    public void validation(List<String> errorList, ValidateObject validateObject) {
        errorList.add("dob errors");
        validateObject.getDateOfBirth();
    }
}
