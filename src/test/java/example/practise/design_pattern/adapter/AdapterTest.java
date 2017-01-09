package example.practise.design_pattern.adapter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AdapterTest {
    @Test
    public void shouldReturnOldResultWhenInvokeOldMethod() {
        //Given
        OldClass oldClass = new OldClass();

        //When
        String result = oldClass.getResult();

        //Then
        assertThat(result, is("old class method"));
    }

    @Test
    public void shouldReturnNewResultWhenInvokeAdapterWithoutChangeOldClass() {
        //Given
        OldClass adapter = new Adapter();

        //When
        String result = adapter.getResult();

        //Then
        assertThat(result, is("new class method"));
    }
}
