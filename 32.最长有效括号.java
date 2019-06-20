/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */
class Solution {
    public int longestValidParentheses(String s) {
        char[] sChar = s.toCharArray();

        while (true) {
            boolean startLeft = false;
            int startI = 0;
            boolean hasChange = false;
            for (int i = 0; i < sChar.length; i++) {
                if (!startLeft && sChar[i] == '(') {
                    startLeft = true;
                    startI = i;
                } else if (startLeft && sChar[i] == '(') {
                    startLeft = true;
                    startI = i;
                } else if (startLeft && sChar[i] == ')') {
                    startLeft = false;
                    sChar[startI] = '-';
                    sChar[i] = '-';
                    hasChange = true;
                }
            }

            if (!hasChange) {
                break;
            }
        }

        int max = 0;
        int temp = 0;
        for (int i = 0; i < sChar.length; i++) {
            if (i != 0 && sChar[i] == '-' && sChar[i - 1] != '-') {
                if (max < temp) {
                    max = temp;
                }
                temp = 1;
            } else if (sChar[i] == '-') {
                temp++;
            }
        }
        if (max < temp) {
            max = temp;
        }

        return max;
    }
}
