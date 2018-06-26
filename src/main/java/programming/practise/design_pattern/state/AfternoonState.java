package programming.practise.design_pattern.state;

public class AfternoonState implements State {

    @Override
    public String changeState(StateContext stateContext) {
        return "afternoon";
    }
}
