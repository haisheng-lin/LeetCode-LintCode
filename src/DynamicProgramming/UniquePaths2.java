package DynamicProgramming;

/**
 * Created by Lin on 2017/6/28.
 */
public class UniquePaths2 {
    /**
     * Follow up for "Unique Paths": Now consider if some obstacles are added to the grids. How many unique paths would there be?
     *
     * @see <a href="https://leetcode.com/problems/unique-paths-ii/#/description">LeetCode</a>
     *
     * @param obstacleGrid 2D matrix
     * @return Number of unique paths
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // corner case
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;

        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];

        for(int r = 0; r < rows; r++){
            if(obstacleGrid[r][0] == 0) dp[r][0] = 1;
            else break;
        }

        for(int c = 0; c < cols; c++){
            if(obstacleGrid[0][c] == 0) dp[0][c] = 1;
            else break;
        }

        for(int r = 1; r < rows; r++){
            for(int c = 1; c < cols; c++){
                if(obstacleGrid[r][c] == 0){
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
