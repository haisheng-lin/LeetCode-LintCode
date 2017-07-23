package Array;

/**
 * Created by Lin on 2017/7/17.
 */
public class TwoSum2 {
    /**
     * Given an array of integers that is already sorted in ascending order
     * Find two numbers such that they add up to a specific target number
     *
     * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description">LeetCode</a>
     *
     * @param nums An array
     * @param target An integer
     * @return two numbers such that they add up to a specific target number
     */
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        int start = 0, end = nums.length - 1;

        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum > target) end--;
            else if(sum < target) start++;
            else {
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            }
        }

        return res;
    }
}
