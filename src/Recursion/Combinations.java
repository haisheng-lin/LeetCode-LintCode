package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class Combinations {
    /**
     * @see <a href="https://leetcode.com/problems/combinations/">LeetCode</a>
     *
     * @param n An Integer, the range of numbers
     * @param k An Integer, the numbers of combinations
     * @return All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int depth,int n, int k){
        // corner case
        if(k == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = depth; i <= n; i++){
            list.add(depth);
            dfs(res, list, depth + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}
