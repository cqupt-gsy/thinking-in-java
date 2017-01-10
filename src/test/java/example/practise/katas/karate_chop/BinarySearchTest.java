/*
1.As you’re coding each algorithm, keep a note of the kinds of error you encounter.
(that is, do you learn from experience in one technique when it comes to coding with a different technique?)
--第一次实现时产生了死循环，原因是在找到了元素后没有及时返回，因此没有退出循环
--打开查找不存在的数据的奇数列表测试用例后再次产生死循环，产生原因是在与中间数比较后，需要把下次比较的索引往前移动一个位置



2.What can you say about the relative merits of the various techniques you’ve chosen?
Which is the most likely to make it in to production code?
Which was the most fun to write?
Which was the hardest to get working?
And for all these questions, ask yourself “why?”.
--java8 lambda 表达式，理解java8的函数式编程以及减少编码



3.How did you go about coming up with approaches four and five?
What techniques did you use to fire those “off the wall” neurons?
--loop



*/
package example.practise.katas.karate_chop;

import com.google.common.collect.Lists;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BinarySearchTest {

    @Test
    public void shouldReturnMinusOneWhenArrayIsNullOrNotFindTheDataInArrayWithLoopChop() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oneElementList = createOneElementList();

        //Then
        assertThat(binarySearch.loopChop(3, createEmptyList())).isEqualTo(-1);
        assertThat(binarySearch.loopChop(3, oneElementList)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(1, oneElementList)).isEqualTo(0);
    }

    @Test
    public void shouldReturnIndicesOfElementInOddListWithLoopChop() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.loopChop(1, oddElementsList)).isEqualTo(0);
        assertThat(binarySearch.loopChop(3, oddElementsList)).isEqualTo(1);
        assertThat(binarySearch.loopChop(5, oddElementsList)).isEqualTo(2);
    }

    @Test
    public void shouldReturnMinusOneWhenElementCantFindInOddListWithLoopChop() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.loopChop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(6, oddElementsList)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnIndicesOfElementInEvenListWithLoopChop() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> evenElementsList = createEvenElementsList();

        //Then
        assertThat(binarySearch.loopChop(1, evenElementsList)).isEqualTo(0);
        assertThat(binarySearch.loopChop(3, evenElementsList)).isEqualTo(1);
        assertThat(binarySearch.loopChop(5, evenElementsList)).isEqualTo(2);
        assertThat(binarySearch.loopChop(7, evenElementsList)).isEqualTo(3);
    }

    @Test
    public void shouldReturnMinusOneWhenElementCantFindInEvenListWithLoopChop() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.loopChop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(6, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(8, oddElementsList)).isEqualTo(-1);
    }

    @Ignore
    @Test
    public void shouldReturnMinusOneWhenArrayIsNullOrNotFindTheDataInArrayWithRecursiveChop() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oneElementList = createOneElementList();

        //Then
        assertThat(binarySearch.recursiveChop(3, createEmptyList())).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(3, oneElementList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(1, oneElementList)).isEqualTo(0);
    }

    @Ignore
    @Test
    public void shouldReturnIndicesOfElementInOddListWithRecursiveChop() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.recursiveChop(1, oddElementsList)).isEqualTo(0);
        assertThat(binarySearch.recursiveChop(3, oddElementsList)).isEqualTo(1);
        assertThat(binarySearch.recursiveChop(5, oddElementsList)).isEqualTo(2);
    }

    @Ignore
    @Test
    public void shouldReturnMinusOneWhenElementCantFindInOddListWithRecursiveChop() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.recursiveChop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(6, oddElementsList)).isEqualTo(-1);
    }

    @Ignore
    @Test
    public void shouldReturnIndicesOfElementInEvenListWithRecursiveChop() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> evenElementsList = createEvenElementsList();

        //Then
        assertThat(binarySearch.recursiveChop(1, evenElementsList)).isEqualTo(0);
        assertThat(binarySearch.recursiveChop(3, evenElementsList)).isEqualTo(1);
        assertThat(binarySearch.recursiveChop(5, evenElementsList)).isEqualTo(2);
        assertThat(binarySearch.recursiveChop(7, evenElementsList)).isEqualTo(3);
    }

    @Ignore
    @Test
    public void shouldReturnMinusOneWhenElementCantFindInEvenListWithRecursiveChop() {
        //Given
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.recursiveChop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(6, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(8, oddElementsList)).isEqualTo(-1);
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
