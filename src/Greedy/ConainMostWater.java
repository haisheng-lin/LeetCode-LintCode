package Greedy;

/**
 * Created by Lin on 2017/2/12.
 */
public class ConainMostWater {
    /**
     * @see <a href="https://leetcode.com/problems/container-with-most-water/">LeetCode</a>
     *
     * @param height An Integer array
     * @return An Integer, area that container contains the most water
     */
    public int maxArea(int[] height){
        int res = 0;
        int start = 0, end = height.length - 1;
        while(start < end){
            int area = (end - start) * Math.min(height[start], height[end]);
            res = Math.max(res, area);
            if(height[start] < height[end]){
                int temp = height[start];
                while(start < end && height[start] <= temp) start++;
            }
            else{
                int temp = height[end];
                while(start < end && height[end] <= temp) end--;
            }
        }

        return res;
    }
}
