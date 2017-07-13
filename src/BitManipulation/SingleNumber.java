package BitManipulation;

/**
 * Created by Lin on 2017/7/12.
 */
public class SingleNumber {
    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *
     * @see <a href="https://leetcode.com/problems/single-number/#/description">LeetCode</a>
     *
     * @param nums An array of integers
     * @return The single element
     */
    public int singleNumber(int[] nums) {
        int target = 0;
        for(int num: nums) target ^= num;

        return target;
    }
}
