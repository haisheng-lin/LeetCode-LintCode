package DynamicProgramming;

/**
 * Created by Lin on 2017/2/12.
 */
public class EditDistance {
    /**
     * You have the following 3 operations permitted on a word: insert a character; delete a character; replace a character
     * @see <a href="https://leetcode.com/problems/edit-distance/">LeetCode</a>
     *
     * @param word1 A String.
     * @param word2 A String.
     * @return The minimum number of steps changing from word1 to word2.
     */
    public int minDistance(String word1, String word2) {
        // special case
        if(word1.equals(word2)) return 0;

        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= n; i++){
            dp[0][i] = i;
        }

        for(int row = 1; row <= m; row++){
            for(int col = 1; col <= n; col++){
                char c1 = word1.charAt(row - 1), c2 = word2.charAt(col - 1);
                if(c1 == c2) dp[row][col] = dp[row - 1][col - 1];
                else dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
            }
        }

        return dp[m][n];
    }
}
