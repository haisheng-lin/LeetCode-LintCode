package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lin on 2017/9/11.
 */
public class KDiffPairsInAnArray {
    /**
     * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array
     * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k
     *
     * @see <a href="https://leetcode.com/problems/k-diff-pairs-in-an-array/">LeetCode</a>
     *
     * @param nums Integer array
     * @param k Integer
     * @return Number of unique k-diff pairs in the array
     */
    public int findPairs(int[] nums, int k) {

        if(k < 0) return 0;

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        if(k > 0) {
            for(int num: nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if(map.containsKey(num + k) && map.get(num) == 1) count++;
                if(map.containsKey(num - k) && map.get(num) == 1) count++;
            }
        } else {
            for(int num: nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if(map.get(num) == 2) count++;
            }
        }

        return count;
    }
}
