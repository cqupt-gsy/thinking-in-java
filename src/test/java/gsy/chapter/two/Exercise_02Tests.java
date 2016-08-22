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
        assertEquals(0, exercise01.getIndex());
    }

    @Test
    public void shouldReturnZeroWhenGetTheCharDefaultValue() {
        assertEquals(0, exercise01.getCharacter());
    }

    @Test
    public void shouldReturnNullWhenGetTheStringDefaultValue() {
        assertEquals(null, exercise01.getStrings());
    }

    @Test
    public void shouldReturnZeroPointZeroWhenGetTheFloatDefaultValue() {
        assertEquals(0.0, exercise01.getFloats(), 1);

    }
}
