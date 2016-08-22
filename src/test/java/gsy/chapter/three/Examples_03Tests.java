package gsy.chapter.three;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples_03Tests {
    private Examples_03 examples03;

    @Before
    public void setUp() throws Exception {
        examples03 = new Examples_03();
    }

    @Test
    public void shouldReturnTheNameThatAssignToTheVariable() {
        examples03.setIndex(45);
        assertEquals(45, examples03.getIndex());
    }

    @Test
    public void shouldReturnTheSameValueWhenGivingTheObjectVarToAnother() {
        Examples_03 examples_03 = new Examples_03();
        examples03.setIndex(24);
        examples_03.setIndex(25);

        assertEquals(24, examples03.getIndex());
        assertEquals(25, examples_03.getIndex());

        examples_03 = examples03;
        assertEquals(24, examples_03.getIndex());

        examples03.setIndex(66);
        assertEquals(66, examples_03.getIndex());
    }

    @Test
    public void shouldReturnTheSameValueWhenGivingTheObjectToTheFunc() {
        examples03.setIndex(24);
        assertEquals(24, examples03.getIndex());

        changeTheObjectValueInFunction(examples03);
        assertEquals(66, examples03.getIndex());
    }

    private void changeTheObjectValueInFunction(Examples_03 examples03) {
        examples03.setIndex(66);
    }
}
