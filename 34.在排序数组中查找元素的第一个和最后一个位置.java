/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, 0, nums.length - 1, target);
    }

    public int[] searchRange(int[] nums, int start, int end, int target){
        if (start > nums.length - 1 || start < 0 || end > nums.length - 1 || end < 0 || end < start){
            int [] notFound = new int[]{-1, -1};
            return notFound;
        }
        int median = (start + end) / 2;
        if (nums[median] < target){
            return searchRange(nums, median + 1, end, target);
        }
        if (nums[median] > target){
            return searchRange(nums, start, median - 1, target);
        }

        if (nums[median] == target){
            int sIndex = median;
            int eIndex = median;

            int sIndexTemp = searchRange(nums, start, median -1, target)[0];

            int eIndexTemp = searchRange(nums, median + 1, end, target)[1];

            if (sIndexTemp >= 0){
                sIndex = sIndexTemp;
            }

            if (eIndexTemp >= 0){
                eIndex = eIndexTemp;
            }

            return new int[]{sIndex, eIndex};
        }

        return new int[]{-1, -1};
    }
}
// @lc code=end

