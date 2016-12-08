package example.practise.design.validatestrategy.strategies;

import example.practise.design.validatestrategy.validateobjects.ValidateObject;

import java.util.List;

public class DobValidateStrategy implements ValidateStrategy {


    @Override
    public void validation(List<String> errorList, ValidateObject validateObject) {
        errorList.add("dob errors");
        validateObject.getDateOfBirth();
    }
}
