/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] charCountsSqua = new int[9][9];

        for (int i = 0; i < 9; i++) {
            int[] charCountsCol = new int[9];
            int[] charCountsRow = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    charCountsRow[board[i][j] - '1'] += 1;
                    if (charCountsRow[board[i][j] - '1'] > 1) {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    charCountsCol[board[j][i] - '1'] += 1;
                    if (charCountsCol[board[j][i] - '1'] > 1) {
                        return false;
                    }
                }
            }

            for (int j = 0; j < 9; j++) {
                if (charCountsCol[j] > 1 || charCountsRow[j] > 1) {
                    return false;
                }
            }

            for (int l = 0; l < 3; l++) {
                int squarIndex = (i / 3) * 3 + l;
                for (int j = 0; j < 3; j++) {
                    if (board[i][l * 3 + j] != '.') {
                        charCountsSqua[squarIndex][board[i][l * 3 + j] - '1'] += 1;
                        if (charCountsSqua[squarIndex][board[i][l * 3 + j] - '1'] > 1) {
                            return false;
                        }
                    }
                }
            }

        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (charCountsSqua[i][j] > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end
