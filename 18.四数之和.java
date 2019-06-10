import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> fourSumResults = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i + 1] > 0 && nums[i] > target) {
                break;
            }
            List<List<Integer>> result = threeSum(nums, i + 1, nums.length - 1, target - nums[i]);
            if (!result.isEmpty()) {
                for (List<Integer> candidate : result) {
                    candidate.add(nums[i]);
                    fourSumResults.add(candidate);
                }
            }
        }

        return fourSumResults;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> threeSumResults = new ArrayList<>();
        for (int i = start; i < end - 1; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i + 1] > 0 && nums[i] > target) {
                break;
            }
            List<List<Integer>> result = twoSum(nums, i + 1, nums.length - 1, target - nums[i]);
            if (!result.isEmpty()) {
                for (List<Integer> candidate : result) {
                    candidate.add(nums[i]);
                    threeSumResults.add(candidate);
                }
            }
        }
        return threeSumResults;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> twoSumResults = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i + 1] > 0 && nums[i] > target) {
                break;
            }
            Integer result = oneSum(nums, i + 1, nums.length - 1, target - nums[i]);
            if (result != null) {
                List<Integer> candidate = new ArrayList<>();
                candidate.add(nums[i]);
                candidate.add(result);
                twoSumResults.add(candidate);
            }
        }
        return twoSumResults;
    }

    public Integer oneSum(int[] nums, int start, int end, int target) {
        int index = Arrays.binarySearch(nums, start, end + 1, target);
        if (index < 0) {
            return null;
        }
        return nums[index];
    }
}
