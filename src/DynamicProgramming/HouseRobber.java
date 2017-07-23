package DynamicProgramming;

/**
 * Created by Lin on 2017/7/21.
 */
public class HouseRobber {
    /**
     * @see <a href="https://leetcode.com/problems/house-robber/#/description">LeetCode</a>
     *
     * @param nums An array representing the amount of money of each house
     * @return Integer, the maximum amount of money you can rob
     */
    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 2];

        for(int i = 0; i < nums.length; i++){
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }

        return dp[nums.length + 1];
    }
}
