package Others;

/**
 * Created by Lin on 2017/6/21.
 */
public class RotateImage {
    /**
     * This method is to rotate a n*n 2D image by 90 degrees (clockwise).
     *
     * @see <a href="https://leetcode.com/problems/rotate-image/#/description">LeetCode</a>
     *
     * @param matrix n*n 2D matrix
     * @return void
     */
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for(int i = 0; i < n/2; i++){
            for(int j = i; j < n-i-1; j++){
                int temp1 = matrix[i][j];
                int temp2 = matrix[j][n - i - 1];
                int temp3 = matrix[n - i - 1][n - j - 1];
                int temp4 = matrix[n - j - 1][i];

                matrix[i][j] = temp4;
                matrix[j][n - i - 1] = temp1;
                matrix[n - i - 1][n - j - 1] = temp2;
                matrix[n - j - 1][i] = temp3;
            }
        }
    }
}
