package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lin on 2017/2/12.
 */
public class CombinationSumII {
    /**
     * Given a collection of candidate numbers (C) and a target number (T), This method is to find all unique combinations in C where the candidate numbers sums to T.
     * Each number in C may only be used once in the combination.
     *
     * @see <a href="https://leetcode.com/problems/combination-sum-ii/">LeetCode</a>
     *
     * @param candidates An Integer array
     * @param target An Integer
     * @return All the combinations that sum to target
     *
     * all numbers can be used only once in each combination
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, candidates, target, 0, new ArrayList<Integer>());

        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, int depth, List<Integer> list){
        // corner case
        if(target == 0) res.add(new ArrayList<>(list));

        int curNum = 0;
        boolean used = false;
        for(int i = depth; i < candidates.length && target >= candidates[i]; i++){
            // avoid duplicate
            if(used && curNum == candidates[i]) continue;
            used = true;
            curNum = candidates[i];

            list.add(candidates[i]);
            dfs(res, candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
