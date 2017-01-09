package example.practise.design_pattern.state;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StateTest {

    @Test
    public void shouldChangeStateByStateContext() {
        //Given
        State state = new NormalState();
        StateContext stateContext = new StateContext(state);
        stateContext.setStateValue(9);

        //When
        String result = stateContext.changeState();

        //Then
        assertThat(result, is("normal"));

    }

    @Test
    public void shouldNormalStateToLunchStateByStateContext() {
        //Given
        State state = new NormalState();
        StateContext stateContext = new StateContext(state);
        stateContext.setStateValue(12);

        //When
        String result = stateContext.changeState();

        //Then
        assertThat(result, is("lunch"));

    }

    @Test
    public void shouldNormalStateToAfternoonStateByStateContext() {
        //Given
        State state = new NormalState();
        StateContext stateContext = new StateContext(state);
        stateContext.setStateValue(18);

        //When
        String result = stateContext.changeState();

        //Then
        assertThat(result, is("afternoon"));

    }
}
