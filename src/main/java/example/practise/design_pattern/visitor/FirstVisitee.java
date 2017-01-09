package example.practise.design_pattern.visitor;

public class FirstVisitee implements Visitee {
    private String value;

    @Override
    public void accept(Visitor visitor) {
        visitor.actionOn(this);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {

        this.value = value;
    }
}
