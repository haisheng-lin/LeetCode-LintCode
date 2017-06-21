package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class SearchRange {
    /**
     * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
     * @see <a href="https://leetcode.com/problems/search-for-a-range/">LeetCode</a>
     *
     * @param nums An integer sorted array
     * @param target An integer to be inserted
     * @return Array of length 2, [index1, index2]
     */
    public int[] searchRange(int[] nums, int target) {

        int[] range = {-1, -1};
        int start = 0, end = nums.length - 1;

        // search the start position
        while(start <= end){
            int mid = start + (end - start) / 2;

            // mid smaller than target
            if(nums[mid] < target) start = mid + 1;

            // mid larger than target
            else if(nums[mid] > target) end = mid - 1;

            // mid equals to target
            else{
                range[0] = (range[0] == -1) ? mid : Math.min(range[0], mid);
                end = mid - 1;
            }
        }

        // reset variables
        start = 0;
        end = nums.length - 1;

        // search the end position
        while(start <= end){
            int mid = start + (end - start) / 2;

            // mid smaller than target
            if(nums[mid] < target) start = mid + 1;

            // mid larger than target
            else if(nums[mid] > target) end = mid - 1;

            // mid equals to target
            else{
                range[1] = Math.max(range[1], mid);
                start = mid + 1;
            }
        }

        return range;
    }
}
