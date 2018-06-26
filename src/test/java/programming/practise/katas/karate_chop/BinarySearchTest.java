/*
1.As you’re coding each algorithm, keep a note of the kinds of error you encounter.
(that is, do you learn from experience in one technique when it comes to coding with a different technique?)
--第一次实现时产生了死循环，原因是在找到了元素后没有及时返回，因此没有退出循环
--打开查找不存在的数据的奇数列表测试用例后再次产生死循环，产生原因是在与中间数比较后，需要把下次比较的索引往前移动一个位置
--第一次没有采用小步实现，在第二次递归实现中，争取采用小步实现，这是个很小的功能，最能锻炼小步提交
--递归查找时，思路直接错误，不能够将原列表切开，需要寻求其他方法
--递归函数实现时，没确定好数据没找到时的退出条件，递归函数退出循环的条件比直接循环的条件更加多，需要写的更加明确

2.What can you say about the relative merits of the various techniques you’ve chosen?
Which is the most likely to make it in to production code? --using third api
Which was the most fun to write? --fun chop implement
Which was the hardest to get working? -- recursive
And for all these questions, ask yourself “why?”.
--java8 lambda 表达式，理解java8的函数式编程以及减少编码
--guava
--assertj
--collections.binarySearch

3.How did you go about coming up with approaches four and five?
What techniques did you use to fire those “off the wall” neurons?
--loop
--recursive
--api
--fun

*/
package programming.practise.katas.karate_chop;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BinarySearchTest {

    private BinarySearch binarySearch;

    @Before
    public void setUp() throws Exception {
        this.binarySearch = new BinarySearch();
    }


    @Test
    public void shouldReturnMinusOneWhenArrayIsNullOrNotFindTheDataInArrayWithLoopChop() {
        //Given
        List<Integer> oneElementList = createOneElementList();

        //Then
        assertThat(binarySearch.loopChop(createEmptyList()).apply(3)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(oneElementList).apply(3)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(oneElementList).apply(1)).isEqualTo(0);
    }

    @Test
    public void shouldReturnIndicesOfElementInOddListWithLoopChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.loopChop(oddElementsList).apply(1)).isEqualTo(0);
        assertThat(binarySearch.loopChop(oddElementsList).apply(3)).isEqualTo(1);
        assertThat(binarySearch.loopChop(oddElementsList).apply(5)).isEqualTo(2);
    }

    @Test
    public void shouldReturnMinusOneWhenElementCantFindInOddListWithLoopChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.loopChop(oddElementsList).apply(0)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(oddElementsList).apply(2)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(oddElementsList).apply(4)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(oddElementsList).apply(6)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnIndicesOfElementInEvenListWithLoopChop() {
        //Given
        List<Integer> evenElementsList = createEvenElementsList();

        //Then
        assertThat(binarySearch.loopChop(evenElementsList).apply(1)).isEqualTo(0);
        assertThat(binarySearch.loopChop(evenElementsList).apply(3)).isEqualTo(1);
        assertThat(binarySearch.loopChop(evenElementsList).apply(5)).isEqualTo(2);
        assertThat(binarySearch.loopChop(evenElementsList).apply(7)).isEqualTo(3);
    }

    @Test
    public void shouldReturnMinusOneWhenElementCantFindInEvenListWithLoopChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.loopChop(oddElementsList).apply(0)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(oddElementsList).apply(2)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(oddElementsList).apply(4)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(oddElementsList).apply(6)).isEqualTo(-1);
        assertThat(binarySearch.loopChop(oddElementsList).apply(8)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnMinusOneWhenArrayIsNullOrNotFindTheDataInArrayWithRecursiveChop() {
        //Given
        List<Integer> oneElementList = createOneElementList();

        //Then
        assertThat(binarySearch.recursiveChop(3, createEmptyList())).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(3, oneElementList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(1, oneElementList)).isEqualTo(0);
    }

    @Test
    public void shouldReturnIndicesOfElementInOddListWithRecursiveChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.recursiveChop(1, oddElementsList)).isEqualTo(0);
        assertThat(binarySearch.recursiveChop(3, oddElementsList)).isEqualTo(1);
        assertThat(binarySearch.recursiveChop(5, oddElementsList)).isEqualTo(2);
    }

    @Test
    public void shouldReturnMinusOneWhenElementCantFindInOddListWithRecursiveChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.recursiveChop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(6, oddElementsList)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnIndicesOfElementInEvenListWithRecursiveChop() {
        //Given
        List<Integer> evenElementsList = createEvenElementsList();

        //Then
        assertThat(binarySearch.recursiveChop(1, evenElementsList)).isEqualTo(0);
        assertThat(binarySearch.recursiveChop(3, evenElementsList)).isEqualTo(1);
        assertThat(binarySearch.recursiveChop(5, evenElementsList)).isEqualTo(2);
        assertThat(binarySearch.recursiveChop(7, evenElementsList)).isEqualTo(3);
    }

    @Test
    public void shouldReturnMinusOneWhenElementCantFindInEvenListWithRecursiveChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.recursiveChop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(6, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.recursiveChop(8, oddElementsList)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnMinusOneWhenArrayIsNullOrNotFindTheDataInArrayWithApiChop() {
        //Given
        List<Integer> oneElementList = createOneElementList();

        //Then
        assertThat(binarySearch.apiChop(3, createEmptyList())).isEqualTo(-1);
        assertThat(binarySearch.apiChop(3, oneElementList)).isEqualTo(-1);
        assertThat(binarySearch.apiChop(1, oneElementList)).isEqualTo(0);
    }

    @Test
    public void shouldReturnIndicesOfElementInOddListWithApiChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.apiChop(1, oddElementsList)).isEqualTo(0);
        assertThat(binarySearch.apiChop(3, oddElementsList)).isEqualTo(1);
        assertThat(binarySearch.apiChop(5, oddElementsList)).isEqualTo(2);
    }

    @Test
    public void shouldReturnMinusOneWhenElementCantFindInOddListWithApiChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.apiChop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.apiChop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.apiChop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.apiChop(6, oddElementsList)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnIndicesOfElementInEvenListWithApiChop() {
        //Given
        List<Integer> evenElementsList = createEvenElementsList();

        //Then
        assertThat(binarySearch.apiChop(1, evenElementsList)).isEqualTo(0);
        assertThat(binarySearch.apiChop(3, evenElementsList)).isEqualTo(1);
        assertThat(binarySearch.apiChop(5, evenElementsList)).isEqualTo(2);
        assertThat(binarySearch.apiChop(7, evenElementsList)).isEqualTo(3);
    }

    @Test
    public void shouldReturnMinusOneWhenElementCantFindInEvenListWithApiChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.apiChop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.apiChop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.apiChop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.apiChop(6, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.apiChop(8, oddElementsList)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnMinusOneWhenArrayIsNullOrNotFindTheDataInArrayWithFunChop() {
        //Given
        List<Integer> oneElementList = createOneElementList();

        //Then
        assertThat(binarySearch.funChop(3, createEmptyList())).isEqualTo(-1);
        assertThat(binarySearch.funChop(3, oneElementList)).isEqualTo(-1);
        assertThat(binarySearch.funChop(1, oneElementList)).isEqualTo(0);
    }

    @Test
    public void shouldReturnIndicesOfElementInOddListWithFunChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.funChop(1, oddElementsList)).isEqualTo(0);
        assertThat(binarySearch.funChop(3, oddElementsList)).isEqualTo(1);
        assertThat(binarySearch.funChop(5, oddElementsList)).isEqualTo(2);
    }

    @Test
    public void shouldReturnMinusOneWhenElementCantFindInOddListWithFunChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.funChop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.funChop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.funChop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.funChop(6, oddElementsList)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnIndicesOfElementInEvenListWithFunChop() {
        //Given
        List<Integer> evenElementsList = createEvenElementsList();

        //Then
        assertThat(binarySearch.funChop(1, evenElementsList)).isEqualTo(0);
        assertThat(binarySearch.funChop(3, evenElementsList)).isEqualTo(1);
        assertThat(binarySearch.funChop(5, evenElementsList)).isEqualTo(2);
        assertThat(binarySearch.funChop(7, evenElementsList)).isEqualTo(3);
    }

    @Test
    public void shouldReturnMinusOneWhenElementCantFindInEvenListWithFunChop() {
        //Given
        List<Integer> oddElementsList = createOddElementsList();

        //Then
        assertThat(binarySearch.funChop(0, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.funChop(2, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.funChop(4, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.funChop(6, oddElementsList)).isEqualTo(-1);
        assertThat(binarySearch.funChop(8, oddElementsList)).isEqualTo(-1);
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
