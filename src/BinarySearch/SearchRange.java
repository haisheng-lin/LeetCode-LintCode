package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class SearchRange {
    /**
     * @see <a href="https://leetcode.com/problems/search-for-a-range/">LeetCode</a>
     *
     * @param A An integer sorted array
     * @param target An integer to be inserted
     * @return A list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] range = {-1, -1};
        int start = 0, end = A.length - 1;
        // search for the first index
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(A[mid] == target){
                end = mid - 1;
                range[0] = (range[0] == -1) ? mid : Math.min(range[0], mid);
            }
            else if(A[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        // search for the last index
        start = 0;
        end = A.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(A[mid] == target){
                start = mid + 1;
                range[1] = Math.max(range[1], mid);
            }
            else if(A[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return range;
    }
}
