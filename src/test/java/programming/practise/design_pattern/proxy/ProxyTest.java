package programming.practise.design_pattern.proxy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProxyTest {

    private ProxyOutPutClass outputClass;

    @Before
    public void setUp() throws Exception {
        outputClass = new ProxyOutPutClass();

    }

    @Test
    public void shouldReturnBasicOutputString() {
        //Then
        assertThat(outputClass.output(), is("Basic Output String"));
    }

    @Test
    public void shouldReturnBasicOutputStringUsingProxy() {
        //Given
        ProxyClass proxy = new ProxyClass();

        //Then
        assertThat(proxy.output(), is("Basic Output String"));
    }
}
