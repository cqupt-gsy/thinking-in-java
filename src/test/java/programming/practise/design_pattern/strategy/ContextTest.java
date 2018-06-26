package programming.practise.design_pattern.strategy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContextTest {

    private Context context;
    private DiscounterStrategy discounter;
    private DiscounterStrategy satisfyReturn;

    @Before
    public void setUp() throws Exception {
        context = new Context();
        discounter = new Discounter(0.9);
        satisfyReturn = new SatisfyReturn(300);
        context.addDiscounterStrategy(satisfyReturn);
        context.addDiscounterStrategy(discounter);
    }

    @Test
    public void shouldReturn190WhenGiven300() {
        //Then
        assertThat(context.getResult(300), is(180.0));


    }
}
