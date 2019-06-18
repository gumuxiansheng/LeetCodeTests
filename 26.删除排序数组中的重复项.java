/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int diffIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                diffIndex++;
                nums[diffIndex] = nums[i];
            }
        }

        return diffIndex + 1;
    }
}

