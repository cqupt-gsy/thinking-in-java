package example.practise.design.flyweight;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FlyweightTest {

    @Test
    public void shouldGetObjectFromFlyweight() {
        //Given
        FlyweightFactory flyweightFactory = new FlyweightFactory();

        //When
        Flyweight firstFlyweight = flyweightFactory.getFlyweight("first");
        Flyweight secondFlyweight = flyweightFactory.getFlyweight("second");

        //Then
        assertTrue(firstFlyweight instanceof FirstFlyweight);
        assertTrue(secondFlyweight instanceof SecondFlyweight);
    }
}
