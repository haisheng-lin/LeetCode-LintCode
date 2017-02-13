package Recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by Lin on 2017/2/12.
 */
public class NQueens {

    // characters for split and queen
    final char empty = '.', queen = 'Q';

    /**
     * This method is to find all distinct solutions to the n-queens puzzle, given an integer n.
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
     *
     * @see <a href="https://leetcode.com/problems/n-queens/">LeetCode</a>
     *
     * @param n An Integer
     * @return All possible of combinations
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<String>(), new HashMap<Integer, Integer>(), n, 0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> list, Map<Integer, Integer> map, int n, int depth){
        // terminate case
        if(depth == n) res.add(new ArrayList<>(list));

        // construct a StringBuilder
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n - 1; i++) sb.append(empty);

        // search an index for insert only one queen to ensure no overlapping in horizontal direction
        for(int i = 0; i < n; i++){
            // there another queen in vertical direction
            if(map.containsValue(i)) continue;
            // there another queen in diagonal position
            boolean flag = false;
            for(int level : map.keySet()){
                if(Math.abs(depth - level) == Math.abs(i - map.get(level))){
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            // map queen level to its position
            map.put(depth, i);
            // next level recursion
            sb.insert(i, queen);
            list.add(sb.toString());
            dfs(res, list, map, n, depth + 1);
            list.remove(list.size() - 1);
            sb.deleteCharAt(i);
            map.remove(depth);
        }
    }

    /***************************************** Separated Line *****************************************/

    private Set<Integer> occupiedCols = new HashSet<>();
    private Set<Integer> occupiedDiag1s = new HashSet<>();
    private Set<Integer> occupiedDiag2s = new HashSet<>();

    public List<List<String>> solveNQueens2(int n){
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, int n, int row){
        // terminate case
        if(row == n) res.add(new ArrayList<>(list));

        // construct a StringBuilder
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n - 1; i++) sb.append(empty);

        // // search an index for insert only one queen to ensure no overlapping in horizontal direction
        for(int col = 0; col < n; col++){
            if(occupiedCols.contains(col)) continue;
            int diag1 = row - col;
            if(occupiedDiag1s.contains(diag1)) continue;
            int diag2 = row + col;
            if(occupiedDiag2s.contains(diag2)) continue;
            // next level recursion
            occupiedCols.add(col);
            occupiedDiag1s.add(diag1);
            occupiedDiag2s.add(diag2);
            sb.insert(col, queen);
            list.add(sb.toString());

            helper(res, list, n, row + 1);

            list.remove(list.size() - 1);
            sb.deleteCharAt(col);
            occupiedDiag2s.remove(diag2);
            occupiedDiag1s.remove(diag1);
            occupiedCols.remove(col);
        }
    }
}
