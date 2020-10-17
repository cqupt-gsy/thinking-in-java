package programming.practise.leetcodes;

import org.junit.Test;
import programming.practise.leetcodes.older.TwoSum_01;

import static org.junit.Assert.assertEquals;

public class TwoSum_01Test {

    @Test
    public void shouldReturnCorrectIndexWithInput324AndTarget6() {
        //Given
        TwoSum_01 twoSum01 = new TwoSum_01();

        //When
        final int[] twoSum = twoSum01.twoSum(new int[]{3, 2, 4}, 6);

        //Then
        assertEquals(twoSum[0], 1);
        assertEquals(twoSum[1], 2);

    }
}