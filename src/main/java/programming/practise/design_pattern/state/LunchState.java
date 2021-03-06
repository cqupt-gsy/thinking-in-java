package programming.practise.design_pattern.state;

public class LunchState implements State {

    @Override
    public String changeState(StateContext stateContext) {
        if (stateContext.getStateValue() == 12) {
            return  "lunch";
        } else {
            stateContext.setNewState(new AfternoonState());
            return stateContext.changeState();
        }
    }
}
