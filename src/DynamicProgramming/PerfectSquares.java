package DynamicProgramming;

/**
 * Created by Lin on 2017/8/2.
 */
public class PerfectSquares {
    /**
     * @see <a href="https://leetcode.com/problems/perfect-squares">LeetCode</a>
     *
     * @param n An integer
     * @return The least number of perfect square numbers which sums to n
     */
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;

            for(int j = 1; j * j <= i; j++){
                min = Math.min(min, dp[i - j * j] + 1);
            }

            dp[i] = min;
        }

        return dp[n];
    }
}
