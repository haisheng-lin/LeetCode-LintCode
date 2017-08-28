package Array;

/**
 * Created by Lin on 2017/8/27.
 */
public class MaximumAverageSubarrayI {
    /**
     * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value
     * You need to output the maximum average value
     *
     * @see <a href="https://leetcode.com/problems/maximum-average-subarray-i/">LeetCode</a>
     *
     * @param nums Integer array
     * @return Maximum average value of contiguous subarray of given length k
     */
    public double findMaxAverage(int[] nums, int k) {

        // sliding window

        double sum = 0;
        for(int i = 0; i < k; i++) sum += nums[i];

        double max = sum;

        for(int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max / k;
    }
}
