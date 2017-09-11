package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lin on 2017/9/11.
 */
public class LongestHarmoniousSubsequence {
    /**
     * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1
     * Given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences
     *
     * @see <a href="https://leetcode.com/problems/longest-harmonious-subsequence/">LeetCode</a>
     *
     * @param nums Integer array
     * @return Length of longest harmonious subsequence
     */
    public int findLHS(int[] nums) {

        int res = 0;
        Map<Integer, int[]> map = new HashMap<>();

        for(int num: nums) {

            if(map.containsKey(num - 1)) map.get(num - 1)[1]++;
            if(map.containsKey(num + 1)) map.get(num + 1)[0]++;

            if(map.containsKey(num)) {
                map.get(num)[0]++;
                map.get(num)[1]++;
            } else {
                int min = map.containsKey(num - 1) ? map.get(num - 1)[1] : 1;
                int max = map.containsKey(num + 1) ? map.get(num + 1)[0] : 1;
                int[] arr = {min, max};
                map.put(num, arr);
            }

            if(map.containsKey(num - 1)) res = Math.max(res, map.get(num)[0]);
            if(map.containsKey(num + 1)) res = Math.max(res, map.get(num)[1]);
        }

        return res;
    }
}
