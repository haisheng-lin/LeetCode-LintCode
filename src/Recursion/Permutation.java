package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class Permutation {

    /***************************************** DFS Version *****************************************/

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


    /***************************************** BFS Version *****************************************/

    /**
     * This method is to find all possible permutations, given a collection of distinct numbers.
     *
     * @see <a href="https://leetcode.com/problems/permutations/">LeetCode</a>
     *
     * @param nums An Integer array
     * @return A list, all possible permutations
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> new_res = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                for(int k = 0; k < res.size(); k++){
                    List<Integer> temp = new ArrayList<Integer>(res.get(k));
                    temp.add(j, nums[i]);
                    new_res.add(temp);
                }
            }

            res = new_res;
        }

        return res;
    }
}
