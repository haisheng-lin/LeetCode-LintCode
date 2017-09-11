package Others;

/**
 * Created by Lin on 2017/9/11.
 */
public class DiagonalTraverse {
    /**
     * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order
     *
     * @see <a href="https://leetcode.com/problems/diagonal-traverse/">LeetCode</a>
     *
     * @param matrix 2D matrix
     * @return Integer array
     */
    public int[] findDiagonalOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0) return new int[0];

        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];

        int r = 0, c = 0;
        boolean toTopRight = true;

        for(int i = 0; i < m * n; i++) {
            res[i] = matrix[r][c];
            if(toTopRight) {
                if(r - 1 >= 0 && c + 1 < n) {
                    r--;
                    c++;
                } else {
                    if(r - 1 < 0 && c + 1 < n) c++;
                    else r++;
                    toTopRight = false;
                }
            } else {
                if(r + 1 < m && c - 1 >= 0) {
                    r++;
                    c--;
                } else {
                    if(r + 1 < m && c - 1 < 0) r++;
                    else c++;
                    toTopRight = true;
                }
            }
        }

        return res;
    }
}
