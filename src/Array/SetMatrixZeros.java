package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class SetMatrixZeros {
    /**
     * If an element is 0, set its entire row and column to 0.
     * @see <a href="https://leetcode.com/problems/set-matrix-zeroes/">LeetCode</a>
     *
     * @param matrix 2D Integer array
     * @return void
     */
    public void setMatrixZeros(int[][] matrix){
        // corner case
        if(matrix == null || matrix.length == 0) return;
        // 标记第一行和第一列的flag
        boolean setRowZero = false, setColZero = false;
        int row = matrix.length, col = matrix[0].length;
        for(int r = 0; r < row; r++){
            if(matrix[r][0] == 0){
                setRowZero = true;
                break;
            }
        }
        for(int c = 0; c < col; c++){
            if(matrix[0][c] == 0){
                setColZero = true;
                break;
            }
        }
        //使用第一行和第一列标记当前matrix[row][col]的行列是否变0
        for(int r = 1; r < row; r++){
            for(int c = 1; c < col; c++){
                if(matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        //根据第一行和第一列的0把对应的行列变0(不包括第一行和第一列)
        for(int r = 1; r < row; r++){
            if(matrix[r][0] == 0){
                for(int c = 1; c < col; c++) matrix[r][c] = 0;
            }
        }
        for(int c = 1; c < col; c++){
            if(matrix[0][c] == 0){
                for(int r = 1; r < row; r++) matrix[r][c] = 0;
            }
        }
        //最后根据flag把第一行和第一列变0
        if(setRowZero){
            for(int r = 0; r < row; r++) matrix[r][0] = 0;
        }
        if(setColZero){
            for(int c = 0; c < col; c++) matrix[0][c] = 0;
        }
    }
}
