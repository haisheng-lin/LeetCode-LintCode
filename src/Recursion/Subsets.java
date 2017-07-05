package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class Subsets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets.
     * The solution set must not contain duplicate subsets.
     *
     * @see <a href="https://leetcode.com/problems/subsets/#/description">LeetCode</a>
     *
     * @param nums A set of numbers.
     * @return A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int depth){

        res.add(new ArrayList<>(list));

        for(int i = depth; i < nums.length; i++){
            list.add(nums[i]);
            dfs(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
