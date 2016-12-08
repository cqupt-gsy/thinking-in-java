package example.practise.design.state;

public class LunchState implements State {
    private Integer state;
    private String stateMessage;

    public LunchState(Integer state) {
        this.state = state;
    }

    @Override
    public String changeState(StateContext stateContext) {
        if (state == 12) {
            return  "lunch";
        } else {
            stateContext.setNewState(new AfternoonState(state));
            return stateContext.changeState();
        }
    }
}
