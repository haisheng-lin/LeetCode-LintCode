package Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lin on 2017/8/30.
 */
public class ZeroOneMatrix {
    /**
     * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell
     * The distance between two adjacent cells is 1
     *
     * @see <a href="https://leetcode.com/problems/01-matrix/">LeetCode</a>
     *
     * @param matrix Integer array
     * @return Distance of the nearest 0 for each cell in form of 2D matrix
     */
    public int[][] updateMatrix(int[][] matrix) {

        int row = matrix.length, col = matrix[0].length;
        int[][] res = new int[row][col];

        Queue<int[]> queue = new LinkedList<>();
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(matrix[r][c] == 0) queue.offer(new int[] {r, c});
                else res[r][c] = Integer.MAX_VALUE;
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {

            int[] loc = queue.poll();
            for(int [] dir: dirs) {

                int r = loc[0] + dir[0];
                int c = loc[1] + dir[1];

                if(r < 0 || r >= row || c < 0 || c >= col || res[r][c] <= res[loc[0]][loc[1]] + 1) continue;
                else {
                    res[r][c] = res[loc[0]][loc[1]] + 1;
                    queue.offer(new int[] {r, c});
                }
            }
        }

        return res;
    }
}
