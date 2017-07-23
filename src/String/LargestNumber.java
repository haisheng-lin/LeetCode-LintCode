package String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Lin on 2017/2/27.
 */
public class LargestNumber {
    /**
     * Given a list of non negative integers, arrange them such that they form the largest number.
     *
     * @see <a href="https://leetcode.com/problems/largest-number/">LeetCode</a>
     *
     * @param nums Integer array.
     * @return String which is the largest number.
     */
    public String largestNumber(int[] nums) {

        // corner case
        if(nums == null || nums.length == 0) return "";


        String res = "";
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);

        // sort the array
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2, str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        });

        // special case
        if(strs[0].charAt(0) == '0') return "0";

        for(String str : strs) res += str;

        return res;
    }
}
