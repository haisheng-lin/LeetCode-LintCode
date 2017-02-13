package Array;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/2/12.
 */
public class SubarraySum {
    /**
     * @see <a href="http://www.lintcode.com/en/problem/subarray-sum/">LeetCode</a>
     *
     * @param nums List of integers
     * @return Index of first number and last number in the sub-array whose sum is 0
     */
    public List<Integer> subarraySum(int[] nums){
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int curSum = 0; // curSum is the sum from index 0 to index i
        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            // if curSum is 0, means that sum from index 0 to i is 0
            if(curSum == 0){
                list.add(0);
                list.add(i);
                break;
            }
            // if map contains curSum, it means there is a sub-array whose sum is 0
            if(map.containsKey(curSum)){
                list.add(map.get(curSum) + 1);
                list.add(i);
                break;
            }
            else map.put(curSum, i);
        }

        return list;
    }
}
