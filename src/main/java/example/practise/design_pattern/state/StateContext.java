package example.practise.design_pattern.state;

public class StateContext {
    private State state;
    private int stateValue;

    public StateContext(State state) {

        this.state = state;
    }

    public void setNewState(State state) {
        this.state = state;
    }

    public String changeState() {
        return state.changeState(this);
    }

    public void setStateValue(int stateValue) {
        this.stateValue = stateValue;
    }

    public int getStateValue() {
        return stateValue;
    }
}
