package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class FindMin {
    /**
     * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">LeetCode</a>
     *
     * @param nums A rotated sorted array, no duplicates
     * @return The minimum number in the array
     */
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        while(start < end){

            int mid = start + (end - start) / 2;
            if(nums[start] < nums[end]) break;

            if(nums[start] > nums[mid]) end = mid;
            else if(nums[mid] > nums[end]) start = mid + 1;
        }

        return nums[start];
    }
}
