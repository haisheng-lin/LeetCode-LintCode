package DynamicProgramming;

/**
 * Created by Lin on 2017/7/26.
 */
public class MinimumSizeSubarraySum {
    /**
     * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
     * If there isn't one, return 0 instead.
     *
     * @see <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">LeetCode</a>
     *
     * @param s An Integer
     * @param nums An integer array
     * @return minimal length of a contiguous subarray of which the sum >= s
     */
    public int minSubArrayLen(int s, int[] nums) {

        int[] sums = new int[nums.length + 1];

        // 记录数组当前位置的和
        for(int i = 1; i <= nums.length; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int[] dp = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){

            // 当前solution中最小的数
            int min = dp[i - 1];

            // 1是所有solution里长度最小的
            if(min == 1){
                dp[i] = min;
                continue;
            }

            // 二分法，找目前距离i最小的数，使得它们之间的和>=s,再与之前的dp[i-1]比较
            int start = (min == 0) ? 0 : i - min + 1;
            int end = i - 1;

            while(start <= end){
                int mid = start + (end - start) / 2;
                if(sums[i] - sums[mid] >= s){
                    min = (min == 0) ? i - mid : Math.min(min, i - mid);
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            }

            dp[i] = min;
        }

        return dp[nums.length];
    }
}
