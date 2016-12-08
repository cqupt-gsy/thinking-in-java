package example.practise.design.validatestrategy;

import java.util.List;

public class OtherValidateStrategy implements ValidateStrategy {
    @Override
    public void validation(List<String> errorList, ValidateObject validateObject) {
        errorList.add("other errors");
        validateObject.getOthers();
    }
}
