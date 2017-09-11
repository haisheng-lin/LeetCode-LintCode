package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Lin on 2017/9/6.
 */
public class PacificAtlanticWaterFlow {
    /**
     * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges
     * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower
     * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean
     *
     * @see <a href="https://leetcode.com/problems/pacific-atlantic-water-flow/">LeetCode</a>
     *
     * @param matrix 2D matrix
     * @return All positions where water can flow to two oceans
     */
    public List<int[]> pacificAtlantic(int[][] matrix) {

        if(matrix == null || matrix.length == 0) return new ArrayList<>();

        List<int[]> res = new ArrayList<>();

        int row = matrix.length, col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for(int r = 0; r < row; r++) {
            dfs(matrix, pacific, r, 0, Integer.MIN_VALUE);
            dfs(matrix, atlantic, r, col - 1, Integer.MIN_VALUE);
        }

        for(int c = 0; c < col; c++) {
            dfs(matrix, pacific, 0, c, Integer.MIN_VALUE);
            dfs(matrix, atlantic, row - 1, c, Integer.MIN_VALUE);
        }

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(pacific[r][c] && atlantic[r][c]) res.add(new int[] {r, c});
            }
        }

        return res;
    }

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] matrix, boolean[][] visited, int r, int c, int height) {

        int row = matrix.length, col = matrix[0].length;

        if(r < 0 || r == row || c < 0 || c == col || visited[r][c] || matrix[r][c] < height) return;

        visited[r][c] = true;

        for(int[] d: dir) {
            dfs(matrix, visited, r + d[0], c + d[1], matrix[r][c]);
        }
    }
}
