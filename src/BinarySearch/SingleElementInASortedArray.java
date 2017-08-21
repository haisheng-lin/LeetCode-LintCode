package BinarySearch;

/**
 * Created by Lin on 2017/8/21.
 */
public class SingleElementInASortedArray {
    /**
     * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once
     * Find this single element that appears only once
     *
     * @see <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">LeetCode</a>
     *
     * @param nums A sorted integer array
     * @return The single element appeared in the array
     */
    public int singleNonDuplicate(int[] nums) {

        // length / 2 = 偶数, Mid 偏右 -> target偏左
        // length / 2 = 偶数, Mid 偏左 -> target偏右
        // length / 2 = 奇数, Mid 偏右 -> target偏右
        // length / 2 = 奇数, Mid 偏左 -> target偏左

        int start = 0, end = nums.length - 1;

        while(start < end) {

            int length = end - start + 1;
            int mid = start + (end - start) / 2;

            if(((length / 2) % 2 == 0 && nums[mid] == nums[mid + 1])) start = mid + 2;
            else if((length / 2) % 2 == 1 && nums[mid - 1] == nums[mid]) start = mid + 1;

            else if(((length / 2) % 2 == 0 && nums[mid - 1] == nums[mid])) end = mid - 2;
            else if((length / 2) % 2 == 1 && nums[mid] == nums[mid + 1]) end= mid - 1;

            else return nums[mid];
        }

        return nums[start];
    }
}
