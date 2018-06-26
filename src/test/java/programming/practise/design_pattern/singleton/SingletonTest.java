package programming.practise.design_pattern.singleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {
    @Test
    public void shouldReturnSameObjectUsingSingleton() {
        //Given
        Singleton singleton_1 = Singleton.getInstance();
        Singleton singleton_2 = Singleton.getInstance();

        //Then
        assertEquals(singleton_1, singleton_2);
    }
}
