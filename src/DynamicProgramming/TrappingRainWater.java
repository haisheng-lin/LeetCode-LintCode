package DynamicProgramming;

/**
 * Created by Lin on 2017/5/13.
 */
public class TrappingRainWater {
    /**
     * @see <a href="https://leetcode.com/problems/trapping-rain-water/#/description">LeetCode</a>
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     *
     * Note: 思维僵化，只会从左往右遍历，不会左右夹逼
     * 答案思维：左右往中间夹逼，找出左右挡板相对短的，那么水的高度就是短板高度（木桶原理），如果遇到当前bar比短板高的话就更换，否则可以增加水的体积
     * @param height Integer array representing heights for each bar
     * @return Integer, how much water can be trapped
     */
    public int trap(int[] height) {

        int res = 0;

        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] > maxLeft) maxLeft = height[left];
                else res += maxLeft - height[left];
                left++;
            }
            else{
                if(height[right] > maxRight) maxRight = height[right];
                else res += maxRight - height[right];
                right--;
            }
        }

        return res;
    }
}
