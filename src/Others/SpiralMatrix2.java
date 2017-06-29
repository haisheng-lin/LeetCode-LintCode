package Others;

/**
 * Created by Lin on 2017/6/27.
 */
public class SpiralMatrix2 {
    /**
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     *
     * @see <a href="https://leetcode.com/problems/spiral-matrix-ii/#/description">LeetCode</a>
     *
     * @param n Integer
     * @return A square matrix filled with elements from 1 to n^2 in spiral order.
     */
    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int num = 1;

        int lr = 0, hr = n - 1, lc = 0, hc = n - 1;
        while(lr <= hr && lc <= hc){
            // 向右，增加行下限
            for(int c = lc; c <= hc; c++) res[lr][c] = num++;
            lr++;
            // 向下，减小列上限
            for(int r = lr; r <= hr; r++) res[r][hc] = num++;
            hc--;
            // 向左，减小行上限
            for(int c = hc; c >= lc; c--) res[hr][c] = num++;
            hr--;
            // 向上，增加列下限
            for(int r = hr; r >= lr; r--) res[r][lc] = num++;
            lc++;
        }

        return res;
    }
}
