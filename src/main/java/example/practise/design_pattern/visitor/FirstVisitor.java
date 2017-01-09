package example.practise.design_pattern.visitor;

public class FirstVisitor implements Visitor {
    @Override
    public void actionOn(Visitee visitee) {
        visitee.setValue("first visitor");
    }
}
