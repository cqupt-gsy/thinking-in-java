package gsy.chapter.two;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise_02Tests {
    private Exercise_02 exercise01;

    @Before
    public void setUp() throws Exception {
        exercise01 = new Exercise_02();
    }

    @Test
    public void shouldReturnZeroWhenGetTheIntergeDefaultValue() {
        assertEquals(exercise01.getIndex(), 0);
    }

    @Test
    public void shouldReturnEmptyCharWhenGetTheCharDefaultValue() {
        assertEquals(exercise01.getCharacter(), 0);
    }


}
