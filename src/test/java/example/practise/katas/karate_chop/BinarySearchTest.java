/*
1.As you’re coding each algorithm, keep a note of the kinds of error you encounter.
(that is, do you learn from experience in one technique when it comes to coding with a different technique?)



2.What can you say about the relative merits of the various techniques you’ve chosen?
Which is the most likely to make it in to production code?
Which was the most fun to write?
Which was the hardest to get working?
And for all these questions, ask yourself “why?”.



3.How did you go about coming up with approaches four and five?
What techniques did you use to fire those “off the wall” neurons?



*/
package example.practise.katas.karate_chop;

import com.google.common.collect.Lists;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BinarySearchTest {

    @Test
    public void shouldReturnMinusOneWhenArrayIsNullOrNotFindTheDataInArray() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oneElementList = createOneElementList();

        //Then
        assertThat(binarySearch.chop(3, createEmptyList())).isEqualTo(-1);
        assertThat(binarySearch.chop(3, oneElementList)).isEqualTo(-1);
        assertThat(binarySearch.chop(1, oneElementList)).isEqualTo(0);
    }

    @Ignore
    @Test
    public void shouldReturnIndicesOfElementInOddList() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.chop(1, oddElementsList)).isEqualTo(0);
        assertThat(binarySearch.chop(3, oddElementsList)).isEqualTo(1);
        assertThat(binarySearch.chop(5, oddElementsList)).isEqualTo(2);
    }

    @Ignore
    @Test
    public void shouldReturnMinusOneWhenElementCantFindInOddList() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.chop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.chop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.chop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.chop(6, oddElementsList)).isEqualTo(-1);
    }


    @Ignore
    @Test
    public void shouldReturnIndicesOfElementInEvenList() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> evenElementsList = createEvenElementsList();

        //Then
        assertThat(binarySearch.chop(1, evenElementsList)).isEqualTo(0);
        assertThat(binarySearch.chop(3, evenElementsList)).isEqualTo(1);
        assertThat(binarySearch.chop(5, evenElementsList)).isEqualTo(2);
        assertThat(binarySearch.chop(7, evenElementsList)).isEqualTo(3);
    }

    @Ignore
    @Test
    public void shouldReturnMinusOneWhenElementCantFindInEvenList() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.chop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.chop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.chop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.chop(6, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.chop(8, oddElementsList)).isEqualTo(-1);
    }

    private List<Integer> createEmptyList() {
        return Lists.newArrayList();
    }

    private List<Integer> createOneElementList() {
        return Lists.newArrayList(1);
    }

    private List<Integer> createOddElementsList() {
        return Lists.newArrayList(1, 3, 5);
    }

    private List<Integer> createEvenElementsList() {
        return Lists.newArrayList(1, 3, 5, 7);
    }
}
