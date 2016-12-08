package example.practise.design.validatestrategy;

import java.util.List;

public class ApplicationValidateStrategy implements ValidateStrategy {


    @Override
    public void validation(List<String> errorList, ValidateObject validateObject) {
        errorList.add("application error");
        validateObject.getApplicationType();
    }
}
