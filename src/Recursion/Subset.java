package Recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lin on 2017/2/12.
 */
public class Subset {
    /**
     * This method is to all possible subsets, given a collection of integers that might contain duplicates.
     * Each element in a subset must be in non-descending order.
     * The ordering between two subsets is free.
     * The solution set must not contain duplicate subsets.
     *
     * @see <a href="http://www.lintcode.com/en/problem/subsets-ii/">LintCode</a>
     *
     * @param nums A set of numbers.
     * @return A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // ensure non-descending order
        dfs(res, new ArrayList<Integer>(), nums, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int depth){
        res.add(new ArrayList<>(list));

        int pre = nums[depth];
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
