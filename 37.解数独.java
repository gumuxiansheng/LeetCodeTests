import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    String availableFull = "123456789";

    public void solveSudoku(char[][] board) {
        // Initial availableNums
        String[][] availableNums = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    availableNums[i][j] = availableFull;
                } else {
                    availableNums[i][j] = String.valueOf(board[i][j]);
                }

            }
        }
        updateAvailable(board, availableNums);

        solveSudoku(board, availableNums);

    }

    public int[] chooseStart(String[][] availableNums) {
        int minLength = 9;
        int[] minPos = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int ijLength = availableNums[i][j].length();
                if (ijLength > 1 && ijLength < minLength) {
                    minLength = ijLength;
                    minPos[0] = i;
                    minPos[1] = j;
                }
            }
        }

        return minPos;
    }

    public void solveSudoku(char[][] board, String[][] availableNums) {
        if (checkFinish(board)){
            return;
        }

        int[] start = chooseStart(availableNums);
        System.out.println(start[0] + ":" + start[1]);
        for (char var : availableNums[start[0]][start[1]].toCharArray()) {
            char[][] boardTemp = arrayCopyChar(board);
            boardTemp[start[0]][start[1]] = var;
            String[][] availableNumsTemp = arrayCopyString(availableNums);
            availableNumsTemp[start[0]][start[1]] = String.valueOf(var);
            updateAvailable(boardTemp, availableNumsTemp);

            solveSudoku(boardTemp, availableNumsTemp);
            if (checkFinish(boardTemp)){
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        board[i][j] = boardTemp[i][j];
                    }
                }
                availableNums = availableNumsTemp;
                return;
            }
        }

    }

    public boolean checkFinish(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkIsValid(char[][] board, int x, int y, char numberChar) {
        for (int i = 0; i < 9; i++) {
            // column and row check
            if ((board[i][y] == numberChar) || (board[x][i] == numberChar)) {
                return false;
            }
        }

        int[][] squareIndexes = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 },
                { 1, 0 }, { 1, 1 } };

        int xAnchor = (int)(x / 3) * 3 + 1;
        int yAnchor = (int)(y / 3) * 3 + 1;
        for (int[] var : squareIndexes) {
            if (board[xAnchor + var[0]][yAnchor + var[1]] == numberChar) {
                return false;
            }
        }

        return true;
    }

    public char[][] arrayCopyChar(char[][] array) {
        char[][] newArray = new char[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                newArray[i][j] = array[i][j];
            }
        }

        return newArray;
    }

    public String[][] arrayCopyString(String[][] array) {
        String[][] newArray = new String[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                newArray[i][j] = array[i][j];
            }
        }

        return newArray;
    }

    public void updateAvailable(char[][] board, String[][] availableNums) {
        for (int i = 0; i < 81; i++) {
            int x = i / 9;
            int y = i % 9;
            String ava = "";
            for (char var : availableNums[x][y].toCharArray()) {
                if (checkIsValid(board, x, y, var)) {
                    ava += var;
                }
            }
            availableNums[x][y] = ava;
            if (ava.length() == 1 && board[x][y] == '.') {
                board[x][y] = ava.charAt(0);
                updateAvailable(board, availableNums);
                break;
            }
        }

    }

}

// @lc code=end
