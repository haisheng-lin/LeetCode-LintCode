package DynamicProgramming;

/**
 * Created by Lin on 2017/2/12.
 */
public class MaximumProduct {
    /**
     * @see <a href="https://leetcode.com/problems/maximum-product-subarray/">LeetCode</a>
     *
     * @param nums An array of integers
     * @return An integer, maximum product of subarray
     *
     */
    public int maxProduct(int[] nums) {
        // corner case
        if(nums == null || nums.length == 0) return 0;

        int[] max = new int[nums.length + 1];
        int[] min = new int[nums.length + 1];
        max[0] = min[0] = 1;
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                max[i + 1] = Math.max(min[i] * nums[i], nums[i]);
                min[i + 1] = Math.min(max[i] * nums[i], nums[i]);
            }
            else{
                max[i + 1] = Math.max(max[i] * nums[i], nums[i]);
                min[i + 1] = Math.min(min[i] * nums[i], nums[i]);
            }
            res = Math.max(res, max[i + 1]);
        }

        return res;
    }
}
