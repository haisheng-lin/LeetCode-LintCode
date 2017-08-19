package Array;

/**
 * Created by Lin on 2017/8/19.
 */
public class RangeAdditionII {
    /**
     * Given an m * n matrix M initialized with all 0's and several update operations
     * Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b
     * Count and return the number of maximum integers in the matrix after performing all the operations
     *
     * @see <a href="https://leetcode.com/problems/range-addition-ii/">LeetCode</a>
     *
     * @param m Integer
     * @param n Integer
     * @param ops 2D integer array
     * @return The number of maximum integers in the matrix after performing all the operations
     */
    public int maxCount(int m, int n, int[][] ops) {

        int row = m, col = n;

        for(int[] op: ops) {
            if(op[0] > 0) row = Math.min(row, op[0]);
            if(op[1] > 0) col = Math.min(col, op[1]);
        }

        return row * col;
    }
}
