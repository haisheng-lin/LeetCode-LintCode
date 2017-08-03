package DynamicProgramming;

/**
 * Created by Lin on 2017/7/29.
 */
public class MaximalSquare {
    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
     *
     * @see <a href="https://leetcode.com/problems/maximal-square/">LeetCode</a>
     *
     * @param matrix An 2D array
     * @return Largest square containing only 1's
     */
    public int maximalSquare(char[][] matrix) {

        // corner case
        if(matrix == null || matrix.length == 0) return 0;

        int max = 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];

        for(int r = 1; r <= row; r++){
            for(int c = 1; c <= col; c++){
                if(matrix[r - 1][c - 1] == '1'){
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                }

                max = Math.max(max, dp[r][c]);
            }
        }

        return max * max;
    }
}
