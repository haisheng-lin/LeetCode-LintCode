package Others;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/6/24.
 */
public class SpiralMatrix {
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     *
     * @see <a href="https://leetcode.com/problems/spiral-matrix/#/description">LeetCode</a>
     *
     * @param matrix m*n matrix
     * @return List that contains all elements of the matrix in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // 边界处理
        if(matrix == null || matrix.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        // 初始化行与列的上限以及下限
        int lr = 0, ur = matrix.length - 1, lc = 0, uc = matrix[0].length - 1;

        while(lr <= ur && lc <= uc){
            // 向右遍历
            if(lr <= ur){
                for(int c = lc; c <= uc; c++) res.add(matrix[lr][c]);
                lr++;
            }
            // 向下遍历
            if(lc <= uc){
                for(int r = lr; r <= ur; r++) res.add(matrix[r][uc]);
                uc--;
            }
            // 向左遍历
            if(lr <= ur){
                for(int c = uc; c >= lc; c--) res.add(matrix[ur][c]);
                ur--;
            }
            // 向上遍历
            if(lc <= uc){
                for(int r = ur; r >= lr; r--) res.add(matrix[r][lc]);
                lc++;
            }
        }

        return res;
    }
}
