package programming.practise.design_pattern.strategy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SatisfyReturnTest {

    private Context context;
    private DiscounterStrategy statisfyReturn;

    @Before
    public void setUp() throws Exception {
        context = new Context();
        statisfyReturn = new SatisfyReturn(300);
        context.addDiscounterStrategy(statisfyReturn);
    }

    @Test
    public void shouldReturn200WhenGivenMoney300() {
        //Then
        assertThat(context.getResult(300), is(200.0));
    }
}
