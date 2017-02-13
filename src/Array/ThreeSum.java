package Array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lin on 2017/2/12.
 */
public class ThreeSum {
    /**
     * @see <a href="https://leetcode.com/problems/3sum/">LeetCode</a>
     *
     * @param nums An array numbers of n integer
     * @return All unique triplets in the array which gives the sum of zero
     */
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            // 当前元素不可和之前的重复
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                int curSum = nums[i] + nums[start] + nums[end];
                // best case
                if(curSum == 0){
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    // 寻找下一个不重复的元素
                    int temp = nums[start];
                    while(start < end && nums[start] == temp) start++;
                    temp = nums[end];
                    while(start < end && nums[end] == temp) end--;
                }
                // sum is positive
                else if(curSum > 0) end--;
                    // sum is negative
                else start++;
            }
        }

        return res;
    }
}
