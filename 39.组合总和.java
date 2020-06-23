import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        int[] candidatesNum = new int[candidates.length + 1];
        candidatesNum[candidates.length] = Integer.MAX_VALUE; // anchor

        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            candidatesNum[i] = target / candidates[i];
            if (candidatesNum[i] == 0) {
                break;
            }

            List<List<Integer>> res = new ArrayList<>();

            for (int j = candidatesNum[i]; j > 0; j--) {
                List<Integer> resultx = new ArrayList<>();

                int tempTarget = target;
                for (int k = 0; k < j; k++) {
                    resultx.add(candidates[i]);
                    tempTarget -= candidates[i];
                }

                if (tempTarget == 0) {
                    res.add(resultx);
                } else {
                    int[] tempCandidates = Arrays.copyOfRange(candidates, i + 1, candidates.length);
                    List<List<Integer>> result = combinationSum(tempCandidates, tempTarget);
                    if (!result.isEmpty()) {
                        for (List<Integer> list : result) {
                            list.addAll(0, resultx);
                        }
        
                        res.addAll(result);
                    }
                    
                }

            }

            r.addAll(res);
        }

        return r;
    }
}
// @lc code=end
