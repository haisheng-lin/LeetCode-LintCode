package Recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lin on 2017/2/12.
 */
public class CombinationSum {
    /**
     * Given a set of candidate numbers (C) (without duplicates) and a target number (T), this method is to find all unique combinations in C where the candidate numbers sums to T.
     * The same repeated number may be chosen from C unlimited number of times.
     *
     * @see <a href="https://leetcode.com/problems/combination-sum/">LeetCode</a>
     *
     * @param candidates A list of integers
     * @param target An integer
     * @return A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            dfs(res, candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
