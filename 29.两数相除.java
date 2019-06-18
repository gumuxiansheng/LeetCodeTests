/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */
class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0) ? false : true;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int remain = dividend;
        int result = 0;
        while (remain <= divisor) {
            int proceed_divisor = divisor;
            int temp_result = 1;

            while (remain - proceed_divisor <= proceed_divisor) {
                temp_result += temp_result;
                proceed_divisor += proceed_divisor;
            }
            remain -= proceed_divisor;

            result -= temp_result;

        }

        if (result == Integer.MIN_VALUE && !isNegative) {
            result++;
        }

        return isNegative ? result : -result;
    }
}
