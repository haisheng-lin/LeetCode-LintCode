package Array;

import java.util.Arrays;

/**
 * Created by Lin on 2017/2/12.
 */
public class ThreeSumClosest {
    /**
     * @see <a href="https://leetcode.com/problems/3sum-closest/">LeetCode</a>
     *
     * @param nums An array numbers of n integer
     * @param target An integer
     * @return The sum of the three integers, the sum closest target
     */
    public int threeSumClosest(int[] nums, int target){
        // Reference: Three-sum
        int max = 0;
        boolean flag = false;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                int curSum = nums[i] + nums[start] + nums[end];
                if(!flag || Math.abs(target - curSum) < Math.abs(target - max)){
                    max = curSum;
                    flag = true;
                }
                // best case
                if(curSum == target) return curSum;
                    // sum is too much
                else if(curSum > target) end--;
                    // sum is too small
                else start++;
            }
        }

        return max;
    }
}
