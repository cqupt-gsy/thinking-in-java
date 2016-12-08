package example.practise.design.validatestrategy.facade;

import example.practise.design.validatestrategy.validateobjects.ValidateObject;

import java.util.List;

public interface ValidateFacade {
    List<String> validate(ValidateObject validateObject);
}
