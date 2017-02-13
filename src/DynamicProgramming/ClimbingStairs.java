package DynamicProgramming;

/**
 * Created by Lin on 2017/2/12.
 */
public class ClimbingStairs {
    /**
     * @see <a href="https://leetcode.com/problems/climbing-stairs/">LeetCode</a>
     *
     * @param n An Integer, total number of stairs
     * @return An Integer, number of ways to climb stairs
     */
    public int climbStairs(int n) {
        // corner case
        if(n == 0) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
