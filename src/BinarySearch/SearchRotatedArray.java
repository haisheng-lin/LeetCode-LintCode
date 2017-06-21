package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class SearchRotatedArray {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     *
     * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">LeetCode</a>
     *
     * @param nums An integer rotated sorted array
     * @param target An integer to be searched
     * @return target index or -1
     */
    public int search(int[] nums, int target) {
        // corner case
        if(nums == null || nums.length == 0) return -1;
        int min = findMin(nums);

        if(target < nums[min]) return -1;
        if(target > nums[nums.length - 1]) return binarySearch(nums, target, 0, min - 1);
        else return binarySearch(nums, target, min, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            // prevent overflow
            int mid = start + (end - start) / 2;

            // mid smaller than target
            if(nums[mid] < target) start = mid + 1;

            // mid larger than target
            else if(nums[mid] > target) end = mid - 1;

            // mid equals to target
            else return mid;
        }

        return -1;
    }

    private int findMin(int[] nums){
        int start = 0, end = nums.length - 1;
        while(start < end){
            // min in the first index
            if(nums[start] < nums[end]) return start;

            // prevent overflow
            int mid = start + (end - start) / 2;

            // min in left half
            if(nums[start] > nums[mid]) end = mid;

            // min in right half
            else start = mid + 1;
        }

        return start;
    }
}
