package DynamicProgramming;

/**
 * Created by Lin on 2017/5/13.
 */
public class JumpGame {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Determine if you are able to reach the last index.
     *
     * @see <a href="https://leetcode.com/problems/jump-game/#/description">LeetCode</a>
     *
     * @param nums An Integer array
     * @return True if you can reach the destination, else false
     */
    public boolean canJump(int[] nums) {
        // 最大到达距离
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            // 注：这两行不可调换顺序！
            // 当前的位置超出最大到达距离，意味着当前位置不可到达
            if(i > max) return false;

            // 如果当前位置可到达，更新最大到达距离
            max = Math.max(max, i + nums[i]);
        }

        return true;
    }
}
