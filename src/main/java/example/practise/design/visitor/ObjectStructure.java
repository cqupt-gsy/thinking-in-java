package example.practise.design.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<Visitee> visitees = new ArrayList<>();

    public void attach(Visitee visitee) {
        visitees.add(visitee);
    }

    public void visit(Visitor visitor) {
        visitees.forEach(visitee -> visitee.accept(visitor));
    }
}
