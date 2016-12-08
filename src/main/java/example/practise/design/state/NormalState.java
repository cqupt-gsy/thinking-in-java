package example.practise.design.state;

public class NormalState implements State {

    private Integer state;

    public NormalState(Integer state) {
        this.state = state;
    }

    @Override
    public String changeState(StateContext stateContext) {
        if (state == 9) {
            return "normal";
        } else {
            stateContext.setNewState(new LunchState(state));
            return stateContext.changeState();
        }
    }
}
