package example.practise.design.chainresponsibility;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HandlerTest {

    @Test
    public void shouldHandleRequestThroughChainOfResponsibilityUsingFirstHandler() {
        //Given
        Handler fieldOneHandler = new FieldOneHandler();
        Handler fieldTwoHandler = new FieldTwoHandler();
        Handler fieldThreeHandler = new FieldThreeHandler();
        fieldOneHandler.setSuperHandler(fieldTwoHandler);
        fieldTwoHandler.setSuperHandler(fieldThreeHandler);

        //When
        String result = fieldOneHandler.handlerRequest(3);

        //Then
        assertThat(result, is("field one"));
    }

    @Test
    public void shouldHandleRequestThroughChainOfResponsibilityUsingSecondHandler() {
        //Given
        Handler fieldOneHandler = new FieldOneHandler();
        Handler fieldTwoHandler = new FieldTwoHandler();
        Handler fieldThreeHandler = new FieldThreeHandler();
        fieldOneHandler.setSuperHandler(fieldTwoHandler);
        fieldTwoHandler.setSuperHandler(fieldThreeHandler);

        //When
        String result = fieldOneHandler.handlerRequest(8);

        //Then
        assertThat(result, is("field two"));
    }

    @Test
    public void shouldHandleRequestThroughChainOfResponsibilityUsingThirdHandler() {
        //Given
        Handler fieldOneHandler = new FieldOneHandler();
        Handler fieldTwoHandler = new FieldTwoHandler();
        Handler fieldThreeHandler = new FieldThreeHandler();
        fieldOneHandler.setSuperHandler(fieldTwoHandler);
        fieldTwoHandler.setSuperHandler(fieldThreeHandler);

        //When
        String result = fieldOneHandler.handlerRequest(12);

        //Then
        assertThat(result, is("field three"));
    }
}
