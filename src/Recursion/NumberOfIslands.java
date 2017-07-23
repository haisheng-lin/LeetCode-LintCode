package Recursion;

/**
 * Created by Lin on 2017/2/27.
 */
public class NumberOfIslands {

    // define the char of island and water
    final char island = '1', water = '0';

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     *
     * @see <a href="https://leetcode.com/problems/number-of-islands/?tab=Description">LeetCode</a>
     *
     * @param grid 2D matrix of map.
     * @return Integer, count of islands.
     */
    public int numIslands(char[][] grid) {
        // count of islands
        int count = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == island){
                    count++;
                    resetZero(grid, row, col);
                }
            }
        }

        return count;
    }

    private void resetZero(char[][] grid, int row, int col){

        // terminate if the current char is 0
        if(grid[row][col] == water) return;

        // set to water
        grid[row][col] = water;

        // leftwards
        if(col > 0) resetZero(grid, row, col - 1);
        // rightwards
        if(col + 1 < grid[row].length) resetZero(grid, row, col + 1);
        // upwards
        if(row > 0) resetZero(grid, row - 1, col);
        // downwards
        if(row + 1 < grid.length) resetZero(grid, row + 1, col);
    }
}
