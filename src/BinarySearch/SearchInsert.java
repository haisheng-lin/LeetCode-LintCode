package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class SearchInsert {
    /**
     * @see <a href="https://leetcode.com/problems/search-insert-position/">LeetCode</a>
     *
     * @param A An integer sorted array
     * @param target An integer to be inserted
     * @return An integer
     */
    public int searchInsert(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while(start < end){
            if(A[start] >= target) return start;
            if(A[end] < target) return end + 1;
            int mid = (start + end) / 2;
            if(target == A[mid]) return mid;
            else if(A[mid] >= target) end = mid - 1;
            else start = mid + 1;
        }

        return A.length;
    }
}
