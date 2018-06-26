package programming.practise.design_pattern.visitor;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VisitorTest {
    @Test
    public void shouldVisitorPersonState() {
        //Given
        ObjectStructure objectStructure = new ObjectStructure();
        Visitee firstVisitee = new FirstVisitee();
        Visitee secondVisitee = new SecondVisitee();
        Visitor firstVisitor = new FirstVisitor();
        Visitor secondVisitor = new SecondVisitor();
        objectStructure.attach(firstVisitee);
        objectStructure.attach(secondVisitee);

        objectStructure.visit(firstVisitor);
        assertThat(firstVisitee.getValue(), is("first visitor"));
        assertThat(secondVisitee.getValue(), is("first visitor"));

        objectStructure.visit(secondVisitor);
        assertThat(firstVisitee.getValue(), is("second visitor"));
        assertThat(secondVisitee.getValue(), is("second visitor"));

    }
}
