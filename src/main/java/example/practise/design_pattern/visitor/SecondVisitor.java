package example.practise.design_pattern.visitor;

public class SecondVisitor implements Visitor {
    @Override
    public void actionOn(Visitee visitee) {
        visitee.setValue("second visitor");
    }
}
