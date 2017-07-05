package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class SearchMatrix {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:
     * (1) Integers in each row are sorted from left to right
     * (2) The first integer of each row is greater than the last integer of the previous row
     *
     * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">LeetCode</a>
     *
     * @param matrix 2D Integer array
     * @param target An integer
     * @return boolean, true if target is found in matrix, else false
     */
    public boolean searchMatrix(int[][] matrix, int target){
        // time complexity: O(nlogn)
        for(int r = 0; r < matrix.length; r++){
            int start = 0, end = matrix[r].length - 1;
            while(start <= end){

                if(target < matrix[r][start]) return false;
                if(target > matrix[r][end]) break;

                int mid = start + (end - start) / 2;
                if(matrix[r][mid] < target) start = mid + 1;
                else if(matrix[r][mid] > target) end = mid - 1;
                else return true;
            }
        }

        return false;
    }
}
