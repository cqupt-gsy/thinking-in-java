package example.practise.design.state;

public class AfternoonState implements State {

    @Override
    public String changeState(StateContext stateContext) {
        return "afternoon";
    }
}
