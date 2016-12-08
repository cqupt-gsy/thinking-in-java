package example.practise.design.validatestrategy.strategies;

import example.practise.design.validatestrategy.validateobjects.ValidateObject;

import java.util.List;

public class ApplicationValidateStrategy implements ValidateStrategy {


    @Override
    public void validation(List<String> errorList, ValidateObject validateObject) {
        errorList.add("application error");
        validateObject.getApplicationType();
    }
}
