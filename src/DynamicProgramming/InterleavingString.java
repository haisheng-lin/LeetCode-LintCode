package DynamicProgramming;

/**
 * Created by Lin on 2017/2/12.
 */
public class InterleavingString {
    /**
     * This method is to determine whether s3 is formed by interleaving of s1 and s2.
     *
     * @see <a href="https://leetcode.com/problems/interleaving-string/">LeetCode</a>
     *
     * @param s1 A String.
     * @param s2 A String.
     * @param s3 A String.
     * @return True if s3 is formed by interleaving of s1 and s2, else false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // 预处理
        dp[0][0] = true;

        for(int r = 0; r < s1.length(); r++){
            if(s1.charAt(r) == s3.charAt(r)) dp[r + 1][0] = true;
            else break;
        }

        for(int c = 0; c < s2.length(); c++){
            if(s2.charAt(c) == s3.charAt(c)) dp[0][c + 1] = true;
            else break;
        }

        // 状态转移方程式
        for(int r = 1; r <= s1.length(); r++){
            for(int c = 1; c <= s2.length(); c++){
                char c1 = s1.charAt(r - 1), c2 = s2.charAt(c - 1), c3 = s3.charAt(r + c - 1);
                if(c1 == c3 && dp[r - 1][c]) dp[r][c] = true;
                else if(c2 == c3 && dp[r][c - 1]) dp[r][c] = true;
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
