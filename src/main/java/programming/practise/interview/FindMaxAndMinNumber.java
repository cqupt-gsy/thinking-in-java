package programming.practise.interview;

import java.util.Arrays;

public class FindMaxAndMinNumber {

    private static class MaxAndMixNumber {
        private int max;
        private int min;

        public MaxAndMixNumber(int max, int min) {

            this.max = max;
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static MaxAndMixNumber findMaxAndMinNumberFromArray(int[] arrayNumbers) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] > max) {
                max = arrayNumbers[i];
            }
            if (arrayNumbers[i] < min) {
                min = arrayNumbers[i];
            }
        }
        return new MaxAndMixNumber(max, min);
    }

    public static void main(String[] args) {
        int[] arrayNumbers = new int[256];
        Arrays.fill(arrayNumbers, 0); //mock initial array numbers
        MaxAndMixNumber maxAndMixNumber = findMaxAndMinNumberFromArray(arrayNumbers);
        System.out.println("Max number is arrays is: " + maxAndMixNumber.getMax());
        System.out.println("Min number is arrays is: " + maxAndMixNumber.getMin());
    }
}
