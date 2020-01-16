package programming.practise.interview;

import java.util.Arrays;
import java.util.Scanner;

//华为笔试
public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String inputValue = sc.nextLine();
        String[] originalString = inputValue.split(" ");

        String stringNeedToCalculate = originalString[0];
        boolean needToLowerCase = true;
        if (originalString.length == 2) {
            needToLowerCase = Boolean.valueOf(originalString[1]);
        }
        int[] characterMapper = new int[256];
        Arrays.fill(characterMapper, 0);
        if (!needToLowerCase) {
            stringNeedToCalculate = stringNeedToCalculate.toLowerCase();
        }
        for (int index = 0; index < stringNeedToCalculate.length(); index++) {
            characterMapper[stringNeedToCalculate.charAt(index)]++;
        }
        int maxValue = -1;
        char result = '0';
        for (int index = 0; index < characterMapper.length; index++) {
            if (characterMapper[index] > maxValue) {
                maxValue = characterMapper[index];
                result = (char) index;
            }
        }

        System.out.println(String.format("%s %d", result, maxValue));
    }
}
