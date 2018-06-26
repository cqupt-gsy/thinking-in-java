package programming.practise.design_pattern.validatestrategy;

import programming.practise.design_pattern.validatestrategy.facade.RealObjectAgainValidateFacade;
import programming.practise.design_pattern.validatestrategy.facade.RealObjectValidateFacade;
import programming.practise.design_pattern.validatestrategy.validateobjects.RealNeedValidateObject;
import programming.practise.design_pattern.validatestrategy.validateobjects.RealNeedValidateObjectAgain;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RealObjectValidateFacadeTest {

    @Test
    public void shouldReturnErrorListWhenValidateRealNeedValidateObject() {
        //Given


        //When
        List<String> errorList = new RealObjectValidateFacade().validate(new RealNeedValidateObject());

        //Then
        assertThat(errorList.size(), is(2));
        assertThat(errorList.get(0), is("application error"));
        assertThat(errorList.get(1), is("dob errors"));
    }

    @Test
    public void shouldReturnErrorListWhenValidateRealNeedValidateObjectAgain() {
        //Given


        //When
        List<String> errorList = new RealObjectAgainValidateFacade().validate(new RealNeedValidateObjectAgain());

        //Then
        assertThat(errorList.size(), is(1));
        assertThat(errorList.get(0), is("other errors"));
    }
}
