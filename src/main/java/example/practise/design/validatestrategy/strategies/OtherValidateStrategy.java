package example.practise.design.validatestrategy.strategies;

import java.lang.reflect.Method;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.uncapitalize;

public class OtherValidateStrategy implements ValidateStrategy {
    @Override
    public void validation(List<String> errorList, Object validateObject) {
        System.out.println(uncapitalize(validateObject.getClass().getSimpleName()));
        try {
            Method method = validateObject.getClass().getDeclaredMethod("getOthers");
            System.out.println("++++" + method.invoke(validateObject));
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorList.add("other errors");
    }
}
