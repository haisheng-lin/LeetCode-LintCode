package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lin on 2017/8/23.
 */
public class ArrayNesting {
    /**
     * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1]
     * Sets S[K] for 0 <= K < N, S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }
     * Sets S[K] are finite for each K and should NOT contain duplicates
     * Given an array A consisting of N integers, return the size of the largest set S[K] for this array
     *
     * @see <a href="https://leetcode.com/problems/array-nesting/">LeetCode</a>
     *
     * @param nums Integer array
     * @return Length of longest array nesting
     */
    public int arrayNesting(int[] nums) {

        int res = 0;
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            int index = nums[i];
            while(visited.add(index)) {
                index = nums[index];
                count++;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}
