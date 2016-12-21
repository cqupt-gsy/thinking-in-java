package example.practise.design.visitor;

public class SecondVisitor implements Visitor {
    @Override
    public void actionOn(Visitee visitee) {
        visitee.setValue("second visitor");
    }
}
