package example.practise.design.validatestrategy.strategies;

import example.practise.design.validatestrategy.validateobjects.ValidateObject;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.uncapitalize;

public class OtherValidateStrategy implements ValidateStrategy {
    @Override
    public void validation(List<String> errorList, ValidateObject validateObject) {
        System.out.println(uncapitalize(validateObject.getClass().getSimpleName()));
        errorList.add("other errors");
        validateObject.getOthers();
    }
}
