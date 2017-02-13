package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class Permutation {
    /**
     * This method is to find all possible permutations, given a collection of distinct numbers.
     *
     * @see <a href="https://leetcode.com/problems/permutations/">LeetCode</a>
     *
     * @param nums An Integer array
     * @return A list, all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
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

        for(int i = depth; i < nums.length; i++){
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
