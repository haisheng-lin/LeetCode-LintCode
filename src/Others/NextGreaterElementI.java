package Others;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lin on 2017/8/21.
 */
public class NextGreaterElementI {
    /**
     * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2
     * Find all the next greater numbers for nums1's elements in the corresponding places of nums2
     *
     * @see <a href="https://leetcode.com/problems/next-greater-element-i/">LeetCode</a>
     *
     * @param nums1 Integer array
     * @param nums2 Integer array
     * @return all the next greater numbers for nums1's elements in the corresponding places of nums2
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++)  map.put(nums2[i], i);

        for(int i = 0; i < nums1.length; i++) {
            int pos = map.get(nums1[i]);
            while(pos < nums2.length && nums2[pos] <= nums1[i]) pos++;
            res[i] = pos == nums2.length ? -1 : nums2[pos];
        }

        return res;
    }
}
