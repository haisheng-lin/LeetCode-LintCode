package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lin on 2017/8/30.
 */
public class SubarraySumEqualsK {
    /**
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k
     *
     * @see <a href="https://leetcode.com/problems/subarray-sum-equals-k/">LeetCode</a>
     *
     * @param nums Integer array
     * @param k Integer
     * @return Number of continuous subarray which sums to k
     */
    public int subarraySum(int[] nums, int k) {

        int res = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
