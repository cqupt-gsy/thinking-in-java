package example.practise.design.state;

public class StateContext {
    private State state;

    public StateContext(State state) {

        this.state = state;
    }

    public void setNewState(State state) {
        this.state = state;
    }

    public String changeState() {
        return state.changeState(this);
    }
}
