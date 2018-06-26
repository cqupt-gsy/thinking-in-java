package programming.practise.leetcodes;

import org.junit.Test;
import programming.practise.leetcodes.MedianofTwoSortedArrays_04;

import static org.junit.Assert.assertEquals;

public class MedianofTwoSortedArrays_04Test {

    @Test
    public void shouldReturnMedianNumber() {
        //Given
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3, 4};

        MedianofTwoSortedArrays_04 medianofTwoSortedArrays = new MedianofTwoSortedArrays_04();

        //When
        double result = medianofTwoSortedArrays.findMedianSortedArrays(num1, num2);

        //Then
        assertEquals(result, 2.5, 0.1);

    }
}