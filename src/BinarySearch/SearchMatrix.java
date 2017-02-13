package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class SearchMatrix {
    /**
     * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">LeetCode</a>
     *
     * @param matrix A list of lists of integers
     * @param target An integer
     * @return boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target){
        // time complexity: O(nlogn)
        for(int i = 0; i < matrix.length; i++){
            int start = 0, end = matrix.length - 1;
            while(start <= end){
                if(matrix[i][start] > target) return false;
                if(matrix[i][end] < target) break;
                int mid = (start + end) / 2;
                if(matrix[i][mid] == target) return true;
                else if(matrix[i][mid] < target) start = mid + 1;
                else end = end - 1;
            }
        }

        return false;
    }
}
