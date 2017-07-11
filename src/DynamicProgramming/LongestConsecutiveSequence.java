package DynamicProgramming;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/7/10.
 */
public class LongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     *
     * @see <a href="https://leetcode.com/problems/longest-consecutive-sequence/#/description">LeetCode</a>
     * @参考 <a href="https://discuss.leetcode.com/topic/6148/my-really-simple-java-o-n-solution-accepted">LeetCode</a>
     *
     * @param nums An array
     * @return Length of the longest consecutive elements sequence
     */
    public int longestConsecutive(int[] nums) {

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            if(map.containsKey(num)) continue;

            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            int sum = left + right + 1;
            res = Math.max(sum, res);

            map.put(num, sum);
            map.put(num - left, sum);
            map.put(num + right, sum);
        }

        return res;
    }
}
