package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Lin on 2017/8/19.
 */
public class MaximumLengthOfPairChain {
    /**
     * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
     * Define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
     * Given a set of pairs, find the length longest chain which can be formed.
     *
     * @see <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/">LeetCode</a>
     *
     * @param pairs An integer array
     * @return The length longest chain which can be formed
     */
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        int res = 0;
        int[] dp = new int[pairs.length];

        for(int[] pair: pairs){

            int num1 = pair[0], num2 = pair[1];

            int i = Arrays.binarySearch(dp, 0, res, num1);
            if(i < 0) i = - (i + 1);

            int j = Arrays.binarySearch(dp, 0, res, num2);
            if(j < 0) j = - (j + 1);

            dp[j] = num2;
            if(i == j && j == res) res++;
        }

        return res;
    }
}
