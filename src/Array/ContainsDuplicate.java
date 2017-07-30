package Array;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by Lin on 2017/7/29.
 */
public class ContainsDuplicate {
    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
     *
     * @see <a href="https://leetcode.com/problems/contains-duplicate/">LeetCode</a>
     *
     * @param nums An array of integers
     * @return True if contains duplicate in the array, else false
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(!set.add(num)) return true;
        }

        return false;
    }
}
