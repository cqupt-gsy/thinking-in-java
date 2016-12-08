package example.practise.design.state;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StateTest {

    @Test
    public void shouldChangeStateByStateContext() {
        //Given
        State state = new NormalState(9);
        StateContext stateContext = new StateContext(state);

        //When
        String result = stateContext.changeState();

        //Then
        assertThat(result, is("normal"));

    }

    @Test
    public void shouldNormalStateToLunchStateByStateContext() {
        //Given
        State state = new NormalState(12);
        StateContext stateContext = new StateContext(state);

        //When
        String result = stateContext.changeState();

        //Then
        assertThat(result, is("lunch"));

    }

    @Test
    public void shouldNormalStateToAfternoonStateByStateContext() {
        //Given
        State state = new NormalState(18);
        StateContext stateContext = new StateContext(state);

        //When
        String result = stateContext.changeState();

        //Then
        assertThat(result, is("afternoon"));

    }
}
