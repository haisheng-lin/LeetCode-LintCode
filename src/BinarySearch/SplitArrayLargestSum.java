package BinarySearch;

/**
 * Created by Lin on 2017/8/29.
 */
public class SplitArrayLargestSum {
    /**
     * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays
     * Write an algorithm to minimize the largest sum among these m subarrays
     *
     * @see <a href="https://leetcode.com/problems/split-array-largest-sum/">LeetCode</a>
     *
     * @param nums A rotated sorted array, no duplicates
     * @param m Integer
     * @return The minimum largest sum among the subarrays
     */
    public int splitArray(int[] nums, int m) {

        int sum = 0, max = Integer.MIN_VALUE;
        for(int num: nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if(m == 1) return sum;

        long start = max, end = sum;
        while(start <= end) {
            long mid = start + (end - start) / 2;
            if(canCut(mid, nums, m)) end = mid - 1;
            else start = mid + 1;
        }

        return (int) start;
    }

    private boolean canCut(long mid, int[] nums, int m) {

        long total = 0, count = 1;

        for(int num: nums) {
            total += num;
            if(total > mid) {
                total = num;
                count++;
                if(count > m) return false;
            }
        }

        return true;
    }
}
