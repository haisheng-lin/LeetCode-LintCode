package Array;

/**
 * Created by Lin on 2017/8/21.
 */
public class ImageSmoother {
    /**
     * Given a 2D integer matrix M representing the gray scale of an image
     * You need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
     * If a cell has less than 8 surrounding cells, then use as many as you can.
     *
     * @see <a href="https://leetcode.com/problems/image-smoother/">LeetCode</a>
     *
     * @param M 2D integer array
     * @return A 2D array
     */
    public int[][] imageSmoother(int[][] M) {

        // corner case
        if(M == null || M.length == 0) return M;

        int row = M.length, col = M[0].length;
        int[][] res = new int[row][col];

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                int count = 1;
                int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0, num7 = 0, num8 = 0;
                if(r - 1 >= 0 && c - 1 >= 0){
                    num1 = M[r - 1][c - 1];
                    count++;
                }
                if(r - 1 >= 0) {
                    num2 = M[r - 1][c];
                    count++;
                }
                if(r - 1 >= 0 && c + 1 < col){
                    num3 = M[r - 1][c + 1];
                    count++;
                }
                if(c - 1 >= 0){
                    num4 = M[r][c - 1];
                    count++;
                }
                if(c + 1 < col){
                    num5 = M[r][c + 1];
                    count++;
                }
                if(r + 1 < row && c - 1 >= 0){
                    num6 = M[r + 1][c - 1];
                    count++;
                }
                if(r + 1 < row){
                    num7 = M[r + 1][c];
                    count++;
                }
                if(r + 1 < row && c + 1 < col){
                    num8 = M[r + 1][c + 1];
                    count++;
                }

                res[r][c] = (num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + M[r][c]) / count;
            }
        }

        return res;
    }
}
