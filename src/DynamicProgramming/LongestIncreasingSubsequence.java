package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by Lin on 2017/8/16.
 */
public class LongestIncreasingSubsequence {
    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.
     *
     * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence/">LeetCode</a>
     *
     * @param nums An integer sorted array
     * @return Length of longest increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {

        int res = 0;
        int[] dp = new int[nums.length];

        for(int num: nums) {
            int i = Arrays.binarySearch(dp, 0, res, num);
            if(i < 0) i = - (i + 1);
            dp[i] = num;
            if(i == res) res++;
        }

        return res;
    }
}
