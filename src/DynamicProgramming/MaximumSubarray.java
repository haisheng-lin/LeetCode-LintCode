package DynamicProgramming;

/**
 * Created by Lin on 2017/2/12.
 */
public class MaximumSubarray {
    /**
     * @see <a href="https://leetcode.com/problems/maximum-subarray/">LeetCode</a>
     *
     * @param nums A list of integers
     * @return An integer, maximum sum of subarray
     */
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE, sum = 0;

        for(int num : nums){
            sum += num;
            max = Math.max(max, sum);
            if(sum < 0) sum = 0;
        }

        return max;
    }
}
