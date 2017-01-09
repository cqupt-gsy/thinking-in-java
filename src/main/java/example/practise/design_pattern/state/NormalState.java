package example.practise.design_pattern.state;

public class NormalState implements State {


    @Override
    public String changeState(StateContext stateContext) {
        if (stateContext.getStateValue() == 9) {
            return "normal";
        } else {
            stateContext.setNewState(new LunchState());
            return stateContext.changeState();
        }
    }
}
