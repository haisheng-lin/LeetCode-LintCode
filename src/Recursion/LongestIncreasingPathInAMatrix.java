package Recursion;

/**
 * Created by Lin on 2017/8/22.
 */
public class LongestIncreasingPathInAMatrix {
    /**
     * Given an integer matrix, find the length of the longest increasing path
     * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary
     *
     * @see <a href="https://leetcode.com/problems/combinations/">LeetCode</a>
     *
     * @param matrix 2D integer array
     * @return Length of longest increasing path
     */
    public int longestIncreasingPath(int[][] matrix) {

        // corner case
        if(matrix.length == 0) return 0;

        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        int res = 0;

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                res = Math.max(res, dfs(matrix, dp, r, c));
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int[][] dp, int r, int c) {

        if(dp[r][c] != 0) return dp[r][c];

        int num1 = 0, num2 = 0, num3 = 0, num4 = 0;

        if(r - 1 >= 0 && matrix[r - 1][c] > matrix[r][c]) num1 = dfs(matrix, dp, r - 1, c);
        if(r + 1 < matrix.length && matrix[r + 1][c] > matrix[r][c]) num2 = dfs(matrix, dp, r + 1, c);
        if(c - 1 >= 0 && matrix[r][c - 1] > matrix[r][c]) num3 = dfs(matrix, dp, r, c - 1);
        if(c + 1 < matrix[0].length && matrix[r][c + 1] > matrix[r][c]) num4 = dfs(matrix, dp, r, c + 1);

        int max = Math.max(Math.max(Math.max(num1, num2), num3), num4);
        dp[r][c] = max + 1;

        return dp[r][c];
    }
}
