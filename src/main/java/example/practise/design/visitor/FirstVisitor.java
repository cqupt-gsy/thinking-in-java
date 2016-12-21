package example.practise.design.visitor;

public class FirstVisitor implements Visitor {
    @Override
    public void actionOn(Visitee visitee) {
        visitee.setValue("first visitor");
    }
}
