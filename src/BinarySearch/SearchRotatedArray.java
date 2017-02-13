package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class SearchRotatedArray {
    /**
     * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">LeetCode</a>
     *
     * @param A An integer rotated sorted array
     * @param target An integer to be searched
     * @return An integer
     */
    public int search(int[] A, int target){
        // corner case
        if(A == null || A.length == 0) return -1;

        int start = 0, end = A.length - 1;
        int rotate = findMin(A);
        if(A[start] > target && rotate > 0) start = rotate;
        else if(A[end] < target && rotate > 0) end = rotate - 1;

        return binarySearch(A, target, start, end);
    }

    private int findMin(int[] A){
        int start = 0, end = A.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(A[start] > A[mid]) end = mid;
            else if(A[mid] > A[end]) start = mid + 1;
        }

        return start;
    }

    private int binarySearch(int[] A, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(A[mid] == target) return mid;
            else if(A[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
}
