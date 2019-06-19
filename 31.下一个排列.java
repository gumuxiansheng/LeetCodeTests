/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */
class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                Arrays.sort(nums);
                return;
            }
            if (nums[i] > nums[i - 1]){
                Arrays.sort(nums, i, nums.length);

                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]){
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
    }
}
