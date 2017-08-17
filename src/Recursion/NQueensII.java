package Recursion;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/2/12.
 */
public class NQueensII {
    /**
     * This method is to find the total number of distinct solutions to the n-queens puzzle, given an integer n.
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
     *
     * @see <a href="https://leetcode.com/problems/n-queens-ii/">LeetCode</a>
     *
     * @param n An Integer
     * @return An Integer, total number of distinct solutions
     */
    public int totalNQueens(int n){
        return dfs(new HashMap<>(), n, 0);
    }

    private int dfs(Map<Integer, Integer> map, int n, int depth){
        // terminate case
        if(depth == n) return 1;

        int res = 0;
        // search an index to insert queen
        for(int i = 0; i < n; i++){
            // there another queen in vertical direction
            if(map.containsValue(i)) continue;
            // there another queen in diagonal position
            boolean flag = false;
            for(int level : map.keySet()){
                if(depth - level == Math.abs(i - map.get(level))){
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            // map queen level to its position
            map.put(depth, i);
            // next level recursion
            res += dfs(map, n, depth + 1);
            map.remove(depth);
        }

        return res;
    }
}
