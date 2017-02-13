package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class FirstPosition {
    /**
     * @see <a href="http://www.lintcode.com/en/problem/first-position-of-target/">LeetCode</a>
     *
     * @param nums The integer array
     * @param target Target to find
     * @return The first position of target. Position starts from 0
     */
    public int firstPosition(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        while(start < end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target) end = mid;
            else start = mid + 1;
        }

        return nums[end] == target ? end : -1;
    }
}
