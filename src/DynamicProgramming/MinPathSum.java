package DynamicProgramming;

/**
 * Created by Lin on 2017/2/12.
 */
public class MinPathSum {
    /**
     * @see <a href="https://leetcode.com/problems/minimum-path-sum/">LeetCode</a>
     *
     * @param grid 2D Integer array
     * @return An Integer, minimum path sum
     */
    public int minPathSum(int[][] grid) {
        // corner case
        if(grid == null || grid.length == 0) return 0;
        // create a 2D array to store minimum path
        int row = grid.length, col = grid[0].length;
        int[][] minPath = new int[row][col];
        // set first row and first column
        for(int r = 0; r < row; r++){
            minPath[r][0] = (r == 0) ? grid[r][0] : minPath[r - 1][0] + grid[r][0];
        }
        for(int c = 0; c < col; c++){
            minPath[0][c] = (c == 0) ? grid[0][c] : minPath[0][c - 1] + grid[0][c];
        }
        // dynamic programming
        for(int r = 1; r < row; r++){
            for(int c = 1; c < col; c++){
                minPath[r][c] = Math.min(minPath[r - 1][c], minPath[r][c - 1]) + grid[r][c];
            }
        }
        // return result
        return minPath[row - 1][col - 1];
    }
}
