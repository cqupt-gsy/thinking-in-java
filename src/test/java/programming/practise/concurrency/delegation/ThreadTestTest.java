package programming.practise.concurrency.delegation;

import org.junit.Test;

import java.util.LinkedList;

public class ThreadTestTest {


    @Test
    public void shouldReturnName() {
        ThreadTest tests = new ThreadTest();
        tests.start();
    }

    @Test
    public void shouldReturnLastElements() {
        int elementNum = 100;
        int[] elements = new int[elementNum];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = i+1;
        }
        int startIndex = 0;

        while ( elementNum > 1) {
            startIndex += 11;
            if (startIndex > elementNum) {
                startIndex = startIndex % elementNum;
            }
            while (elements[startIndex] == -1) {
                startIndex++;
            }

            elements[startIndex] = -1;
            elementNum--;
        }
        for (int i = 0; i < elements.length; i++) {
            if (-1 != elements[i]) {
                System.out.println("Index: " + i + ", Elements: " + elements[i]);
            }
        }
    }


    @Test
    public void shouldReturnLastElementsWithArray() {
        LinkedList elements = new LinkedList();
        int elementsNum = 100;
        for (int i = 0; i < elementsNum; i++) {
            elements.add(i+1);
        }
        int startIndex = 0;
        while ( elements.size() > 1) {
            startIndex = (startIndex + 11) % elements.size();
            elements.remove(startIndex);
        }
        System.out.println("Index: " + elements.get(0));

    }
}