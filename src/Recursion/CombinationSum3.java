package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class CombinationSum3 {
    /**
     * This method is to Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     *
     * @see <a href="https://leetcode.com/problems/combination-sum-iii/">LeetCode</a>
     *
     * @param k An Integer, number of combination
     * @param n An Integer, target sum
     * @return All possible combinations
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), 1, k, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int depth, int k, int n){
        if(k == 0 && n == 0) res.add(new ArrayList<>(list));

        for(int i = depth; i <= 9 && n >= i; i++){
            list.add(i);
            dfs(res, list, i + 1, k - 1, n - i);
            list.remove(list.size() - 1);
        }
    }
}
