/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    public int searchInsert(int[] nums, int start, int end, int target) {
        if (start < 0) {
            return 0;
        }
        if (end > nums.length - 1){
            return nums.length;
        }
        if (end < start){
            return end + 1;
        }
        
        int middle = start + (end - start) / 2;
        if (nums[middle] == target) {
            return middle;
        }

        if (nums[middle] > target){
            if ((middle > 0) && (nums[middle - 1] < target)){
                return middle;
            }

            return searchInsert(nums, start, middle - 1, target);
        }

        if (nums[middle] < target){
            if ((middle < nums.length - 2) && (nums[middle + 1] > target)){
                return middle + 1;
            }
            return searchInsert(nums, middle + 1, end, target);
        }

        return 0;
    }
}
// @lc code=end

