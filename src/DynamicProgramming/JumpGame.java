package DynamicProgramming;

/**
 * Created by Lin on 2017/5/13.
 */
public class JumpGame {
    /**
     * @see <a href="https://leetcode.com/problems/jump-game/#/description">LeetCode</a>
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Determine if you are able to reach the last index.
     *
     * @param nums An Integer array
     * @return True if you can reach the destination, else false
     * */
    public boolean canJump(int[] nums) {
        int maxRange = 0;
        for(int i = 0; i < nums.length; i++){
            // current index cannot be reached
            if(i > maxRange) return false;
            // current index can be reached
            maxRange = Math.max(maxRange, i + nums[i]);
            if(maxRange >= nums.length - 1) return true;
        }

        return false;
    }
}
