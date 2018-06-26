package programming.practise.design_pattern.decorator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OutputClassTest {

    private OutputClass outputClass;

    @Before
    public void setUp() throws Exception {
        outputClass = new OutputClass();
    }

    @Test
    public void shouldReturnOutputString() {
        //Then
        assertThat(outputClass.output(), is("Basic Output"));
    }

    @Test
    public void shouldReturnBasicDecoratorOutputString() {
        //Given
        outputClass = new BasicDecoratorOutputClass(new OutputClass());

        //Then
        assertThat(outputClass.output(), is("Basic Decorator Output"));
    }

    @Test
    public void shouldReturnBasicOutputStringWithBasicDecorator() {
        //Given
        outputClass = new BasicDecoratorOutputClass();

        //Then
        assertThat(outputClass.output(), is("Basic Output"));
    }

    @Test
    public void shouldReturnStreamDecoratorOutputString() {
        //Given
        outputClass =  new StreamDecoratorOutput(new BasicDecoratorOutputClass(new OutputClass()));

        //Then
        assertThat(outputClass.output(), is("Stream Decorator Output"));
    }

    @Test
    public void shouldReturnStreamDecoratorOutputStringWithFirstLayerDecorator() {
        //Given
        outputClass =  new StreamDecoratorOutput(new OutputClass());

        //Then
        assertThat(outputClass.output(), is("Stream Decorator Output"));
    }

    @Test
    public void shouldReturnBasicOutputStringWithStreamDecorator() {
        //Given
        outputClass = new StreamDecoratorOutput();

        //Then
        assertThat(outputClass.output(), is("Basic Output"));
    }

    @Test
    public void shouldReturnScannerDecoratorOutputString() {
        //Given
        outputClass = new ScannerDecoratorOutput(new StreamDecoratorOutput(new BasicDecoratorOutputClass(new OutputClass())));

        //Then
        assertThat(outputClass.output(), is("Scanner Decorator Output"));
    }

    @Test
    public void shouldReturnBasicOutputStringWithScannerDecorator() {
        //Given
        outputClass = new ScannerDecoratorOutput();

        //Then
        assertThat(outputClass.output(), is("Basic Output"));
    }

    @Test
    public void shouldReturnStreamDecoratorOutputStringAgian() {
        //Given
        outputClass = new StreamDecoratorOutput(new ScannerDecoratorOutput(new BasicDecoratorOutputClass(new OutputClass())));

        //Then
        assertThat(outputClass.output(), is("Stream Decorator Output"));
    }
}
