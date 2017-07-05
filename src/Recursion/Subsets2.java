package Recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lin on 2017/7/3.
 */
public class Subsets2 {
    /**
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
     * The solution set must not contain duplicate subsets.
     *
     * @see <a href="https://leetcode.com/problems/subsets-ii/#/description">LeetCode</a>
     *
     * @param nums A set of numbers.
     * @return A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int depth){

        res.add(new ArrayList<>(list));

        int pre = 0;
        boolean used = false;
        for(int i = depth; i < nums.length; i++){
            if(used && pre == nums[i]) continue;
            used = true;
            pre = nums[i];

            list.add(nums[i]);
            dfs(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}