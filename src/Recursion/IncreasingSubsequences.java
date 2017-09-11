package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lin on 2017/9/11.
 */
public class IncreasingSubsequences {
    /**
     * Given an integer array, find all the different possible increasing subsequences of the given array
     * The length of an increasing subsequence should be at least 2
     *
     * @see <a href="https://leetcode.com/problems/increasing-subsequences/">LeetCode</a>
     *
     * @param nums Integer array
     * @return All different possible increasing subsequences
     */
    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0, Integer.MIN_VALUE);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int depth, int pre) {

        if(list.size() > 1) res.add(new ArrayList<>(list));

        Set<Integer> set = new HashSet<>();

        for(int i = depth; i < nums.length; i++) {

            if(pre <= nums[i] && set.add(nums[i])) {
                list.add(nums[i]);
                dfs(res, list, nums, i + 1, nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
