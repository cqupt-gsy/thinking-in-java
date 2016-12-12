package example.practise.design.validatestrategy.strategies;

import java.util.List;

public class ApplicationValidateStrategy implements ValidateStrategy {


    @Override
    public void validation(List<String> errorList, Object validateObject) {
        errorList.add("application error");
//        validateObject.getApplicationType();
    }
}
