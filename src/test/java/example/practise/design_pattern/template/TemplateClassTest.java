package example.practise.design_pattern.template;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TemplateClassTest {

    private TemplateClass templateClass;

    @Before
    public void setUp() throws Exception {
        templateClass = new FirstClass();
    }

    @Test
    public void shouldReturnSubclassOperation() {
        //Then
        assertThat(templateClass.getResult(), is("subclass one"));

    }

    @Test
    public void shouldReturnSubclassOperationTwo() {
        //Given
        templateClass = new SecondClass();

        //Then
        assertThat(templateClass.getResult(), is("subclass two"));


    }
}
