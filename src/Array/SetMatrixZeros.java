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
        // 边界处理
        if(matrix == null || matrix.length == 0) return;

        int rows = matrix.length, cols = matrix[0].length;

        // Step 1: 记录第一行与第一列是否需要全设为0
        boolean setRowZero = false, setColZero = false;
        for(int r = 0; r < rows; r++){
            if(matrix[r][0] == 0){
                setRowZero = true;
                break;
            }
        }
        for(int c = 0; c < cols; c++){
            if(matrix[0][c] == 0){
                setColZero = true;
                break;
            }
        }

        //Step 2: 遍历非第一行与第一列的元素，如果为0则在对应的第一行与第一列记录0
        for(int r = 1; r < rows; r++){
            for(int c = 1; c < cols; c++){
                if(matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        //Step 3: 根据第一行和第一列的0把对应的行列变0(不包括第一行和第一列)
        for(int r = 1; r < rows; r++){
            if(matrix[r][0] == 0){
                for(int c = 1; c < cols; c++) matrix[r][c] = 0;
            }
        }
        for(int c = 1; c < cols; c++){
            if(matrix[0][c] == 0){
                for(int r = 1; r < rows; r++) matrix[r][c] = 0;
            }
        }

        // Step 4: 最后根据flag把第一行和第一列变0
        if(setRowZero){
            for(int r = 0; r < rows; r++) matrix[r][0] = 0;
        }
        if(setColZero){
            for(int c = 0; c < cols; c++) matrix[0][c] = 0;
        }
    }
}
