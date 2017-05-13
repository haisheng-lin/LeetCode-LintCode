package DynamicProgramming;

import com.sun.org.glassfish.gmbal.ManagedAttribute;

/**
 * Created by Lin on 2017/5/13.
 */
public class JumpGame2 {
    /**
     * @see <a href="https://leetcode.com/problems/jump-game-ii/#/description">LeetCode</a>
     * Follow up "Jump Game".
     * Your goal is to reach the last index in the minimum number of jumps.
     * You can assume that you can always reach the last index.
     *
     * @param nums An Integer array
     * @return Integer, minimum number of jumps.
     */
    public int jump(int[] nums){
        // corner case
        if(nums.length <= 1) return 0;

        int currentMax = 0, nextMax = 0, i = 0, level = 0;

        // nodes count of current level
        while(currentMax - i + 1 > 0){
            level++;
            // i is the start index in current level
            // traverse current level , and update the max reach of next level
            while(i <= currentMax){
                nextMax = Math.max(nextMax, nums[i] + i);
                if(nextMax >= nums.length - 1) return level;
                i++;
            }
            currentMax = nextMax;
        }

        return 0;
    }

    /**
     * Time Limit Exceeded
     */
    public int jump2(int[] nums) {

        int[] dp = new int[nums.length];

        for(int i = 1; i < nums.length; i++) dp[i] = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= nums[i] && i + j < nums.length; j++){
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        return dp[nums.length - 1];
    }
}
