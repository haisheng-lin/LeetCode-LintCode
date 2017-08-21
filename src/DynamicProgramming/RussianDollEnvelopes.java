package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Lin on 2017/8/19.
 */
public class RussianDollEnvelopes {
    /**
     * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
     * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
     * What is the maximum number of envelopes can you Russian doll? (put one inside other)
     *
     * @see <a href="https://leetcode.com/problems/russian-doll-envelopes/">LeetCode</a>
     *
     * @param envelopes 2D integer array
     * @return Largest number of Russian doll
     */
    public int maxEnvelopes(int[][] envelopes) {

        int res = 0;
        int[] dp = new int[envelopes.length];

        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o2[1] - o1[1];
                else return o1[0] - o2[0];
            }
        });

        for(int[] envelope: envelopes) {
            int i = Arrays.binarySearch(dp, 0, res, envelope[1]);
            if(i < 0) i = - (i + 1);
            dp[i] = envelope[1];
            if(i == res) res++;
        }

        return res;
    }
}
