package programming.practise.leetcodes.arrays;

import java.util.ArrayList;
import java.util.List;

//螺旋矩阵
public class SpiralArray {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int rightPivot = matrix[0].length;
        int downPivot = matrix.length;
        int leftPivot = 0;
        int upPivot = 0;
        int totalElement = rightPivot * downPivot;

        int row = 0;
        int column = 0;

        while (result.size() < totalElement) {
            while (column < rightPivot && result.size() < totalElement) {
                result.add(matrix[row][column++]);
            }
            upPivot++;
            row++;
            column--;

            while (row < downPivot && result.size() < totalElement) {
                result.add(matrix[row++][column]);
            }
            rightPivot--;
            row--;
            column--;

            while (column >= leftPivot && result.size() < totalElement) {
                result.add(matrix[row][column--]);
            }
            downPivot--;
            row--;
            column++;

            while (row >= upPivot && result.size() < totalElement) {
                result.add(matrix[row--][column]);
            }
            leftPivot++;
            row++;
            column++;

        }
        return result;
    }
}
