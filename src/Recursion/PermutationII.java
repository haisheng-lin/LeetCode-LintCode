package Recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by Lin on 2017/2/12.
 */
public class PermutationII {
    /**
     * This method is to find all unique permutations, given a collection of distinct numbers.
     *
     * @see <a href="https://leetcode.com/problems/permutations-ii/">LeetCode</a>
     *
     * @param nums An Integer array
     * @return A list, all unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int depth){
        // terminate case
        if(depth == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num : nums) list.add(num);
            res.add(list);
        }

        Set<Integer> set = new HashSet<>();
        for(int i = depth; i < nums.length; i++){
            if(!set.add(nums[i])) continue;
            swap(nums, i, depth);
            dfs(res, nums, depth + 1);
            swap(nums, i, depth);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
