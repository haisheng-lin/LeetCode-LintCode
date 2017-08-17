package BinarySearch;

import java.util.Arrays;

/**
 * Created by Lin on 2017/2/12.
 */
public class SearchInsert {
    /**
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     *
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

    /**
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     *
     * @see <a href="https://leetcode.com/problems/search-insert-position/">LeetCode</a>
     *
     * @param nums An integer sorted array
     * @param target An integer to be inserted
     * @return An integer
     */
    public int searchInsert2(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, 0, nums.length, target);
        if(res < 0) res = - (res + 1);
        return res;
    }
}
