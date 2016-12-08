package example.practise.design.state;

public class AfternoonState implements State {
    private Integer state;

    public AfternoonState(Integer state) {
        this.state = state;
    }

    @Override
    public String changeState(StateContext stateContext) {
        return "afternoon";
    }
}
