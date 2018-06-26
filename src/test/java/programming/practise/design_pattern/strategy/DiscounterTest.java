package programming.practise.design_pattern.strategy;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiscounterTest {
    private DiscounterStrategy discounter;
    private Context context;

    @Before
    public void setUp() throws Exception {
        context = new Context();
        discounter = new Discounter(0.9);
        context.addDiscounterStrategy(discounter);
    }

    @Test
    public void shouldReturn90WhenDiscouted() {
        //Then
        assertThat(context.getResult(100), is(90.0));
    }
}
