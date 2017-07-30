package Array;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/7/29.
 */
public class ContainsDuplicate2 {
    /**
     * Given an array of integers and an integer k
     * find out whether there are two distinct indices i and j in the array
     * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     *
     * @see <a href="https://leetcode.com/problems/contains-duplicate-ii/">LeetCode</a>
     *
     * @param nums An array of integers
     * @param k An integer
     * @return True if contains duplicate in given absolute difference of their indices, else false
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }

        return false;
    }
}
