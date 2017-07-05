package DynamicProgramming;

/**
 * Created by Lin on 2017/2/12.
 */
public class MinPathSum {
    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     *
     * @see <a href="https://leetcode.com/problems/minimum-path-sum/">LeetCode</a>
     *
     * @param grid 2D Integer array
     * @return An Integer, minimum path sum
     */
    public int minPathSum(int[][] grid) {

        // corner case
        if(grid == null || grid.length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        int[][] minPath = new int[rows][cols];

        for(int r = 0; r < rows; r++){
            minPath[r][0] = (r == 0) ? grid[r][0] : minPath[r - 1][0] + grid[r][0];
        }
        for(int c = 0; c < cols; c++){
            minPath[0][c] = (c == 0) ? grid[0][c] : minPath[0][c - 1] + grid[0][c];
        }

        for(int r = 1; r < rows; r++){
            for(int c = 1; c < cols; c++){
                minPath[r][c] = Math.min(minPath[r - 1][c], minPath[r][c - 1]) + grid[r][c];
            }
        }

        return minPath[rows - 1][cols - 1];
    }
}
