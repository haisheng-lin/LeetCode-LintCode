package DynamicProgramming;

/**
 * Created by Lin on 2017/7/8.
 */
public class DistinctSubsequences {
    /**
     * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
     *
     * @see <a href="https://leetcode.com/problems/distinct-subsequences/#/description">LeetCode</a>
     *
     * @param s String
     * @param t String
     * @return the number of distinct subsequences of S which equals T
     */
    public int numDistinct(String s, String t) {

        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // 预处理
        for(int c = 0; c <= s.length(); c++) dp[0][c] = 1;

        // 状态转移方程式
        for(int r = 1; r <= t.length(); r++){
            for(int c = 1; c <= s.length(); c++){
                if(t.charAt(r - 1) == s.charAt(c - 1)) dp[r][c] = dp[r - 1][c - 1] + dp[r][c - 1];
                else dp[r][c] = dp[r][c - 1];
            }
        }

        return dp[t.length()][s.length()];
    }
}
