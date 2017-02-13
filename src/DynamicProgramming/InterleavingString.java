package DynamicProgramming;

/**
 * Created by Lin on 2017/2/12.
 */
public class InterleavingString {
    /**
     * This method is to determine whether s3 is formed by interleaving of s1 and s2.
     * @see <a href="https://leetcode.com/problems/interleaving-string/">LeetCode</a>
     *
     * @param s1 A String.
     * @param s2 A String.
     * @param s3 A String.
     * @return True if s3 is formed by interleaving of s1 and s2, else false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // corner case
        if(s3.length() != s1.length() + s2.length()) return false;

        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s3.charAt(i) && dp[i][0]) dp[i + 1][0] = true;
        }
        for(int i = 0; i < s2.length(); i++){
            if(s1.charAt(i) == s3.charAt(i) && dp[0][i]) dp[0][i + 1] = true;
        }

        for(int row = 1; row <= m; row++){
            for(int col = 1; col <= n; col++){
                char c1 = s1.charAt(row - 1), c2 = s2.charAt(col - 1), c3 = s3.charAt(row + col - 1);
                if(c1 == c3 && dp[row - 1][col]){
                    dp[row][col] = true;
                }
                else if(c2 == c3 && dp[row][col - 1]){
                    dp[row][col] = true;
                }
            }
        }

        return dp[m][n];
    }
}
