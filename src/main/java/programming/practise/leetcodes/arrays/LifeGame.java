package programming.practise.leetcodes.arrays;

// 生命游戏
public class LifeGame {
    public static void main(String[] args) {

    }

    public void gameOfLife(int[][] board) {
        int rowSize = board.length;
        if (rowSize == 0) {
            return;
        }
        int columnSize = board[0].length;
        boolean[][] changeStatus = new boolean[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                changeStatus[row][column] = shouldChangeStatus(board, row, column, rowSize, columnSize);
            }
        }

        for (int row = 0; row < changeStatus.length; row++) {
            for (int column = 0; column < changeStatus[row].length; column++) {
                if (changeStatus[row][column]) {
                    board[row][column] = board[row][column] ^ 1;
                }
            }
        }

    }

    private boolean shouldChangeStatus(int[][] board, int row, int column, int rowSize, int columnSize) {
        int currentStatus = board[row][column];
        int rowBegin = row - 1;
        int rowEnd = row + 1;
        int liveSum = 0;

        while (rowBegin <= rowEnd) {
            if (rowBegin < 0) {
                rowBegin++;
                continue;
            }
            if (rowBegin == rowSize) {
                break;
            }
            int columnBegin = column - 1;
            int columnEnd = column + 1;
            while (columnBegin <= columnEnd) {
                if (columnBegin < 0 || (rowBegin == row && columnBegin == column)) {
                    columnBegin++;
                    continue;
                }
                if (columnBegin == columnSize) {
                    break;
                }
                liveSum += board[rowBegin][columnBegin];
                columnBegin++;
            }
            rowBegin++;
        }
        if (currentStatus == 1) {
            return liveSum != 2 && liveSum != 3;
        } else {
            return liveSum == 3;
        }
    }
}
