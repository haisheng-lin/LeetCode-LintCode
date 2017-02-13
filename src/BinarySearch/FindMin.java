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
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[start] < nums[mid] && nums[mid] < nums[end]) return nums[start];
            // rotated point at left
            if(nums[start] > nums[mid]) end = mid;
                // rotated point at right
            else if(nums[mid] > nums[end]) start = mid + 1;
        }

        return nums[end];
    }
}
