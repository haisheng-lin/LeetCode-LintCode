package Array;

/**
 * Created by Lin on 2017/8/6.
 */
public class RangeSumQueryImmutable {

    /**
     * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
     *
     * @see <a href="https://leetcode.com/problems/range-sum-query-immutable/">LeetCode</a>
     */

    int[] sums;

    public RangeSumQueryImmutable(int[] nums) {

        sums = new int[nums.length + 1];
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sums[i + 1] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
