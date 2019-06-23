/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */
class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int start, int end, int target) {
        if (nums.length == 0 || start > end) {
            return -1;
        }
        int midI = (start + end) / 2;
        int mid = nums[midI];
        if (mid == target) {
            return midI;
        }
        if (start == end) {
            return -1;
        }
        if (nums[start] > nums[end]) {
            if (target <= nums[end]) {
                if (target > mid) {
                    return search(nums, midI + 1, end, target);
                } else {
                    if (mid > nums[end]) {
                        return search(nums, midI + 1, end, target);
                    } else {
                        return search(nums, start, midI - 1, target);
                    }
                }
            } else {
                if (target > mid) {
                    if (mid > nums[end]) {
                        return search(nums, midI + 1, end, target);
                    } else {
                        return search(nums, start, midI - 1, target);
                    }
                } else {
                    return search(nums, start, midI - 1, target);
                }
            }
        } else {
            if (target < mid) {
                return search(nums, start, midI - 1, target);
            } else {
                return search(nums, midI + 1, end, target);
            }
        }
    }
}
