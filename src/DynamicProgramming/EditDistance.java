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

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // 预处理
        for(int r = 0; r <= word1.length(); r++) dp[r][0] = r;
        for(int c = 0; c <= word2.length(); c++) dp[0][c] = c;

        // 状态转移方程式
        for(int r = 1; r <= word1.length(); r++){
            for(int c = 1; c <= word2.length(); c++){
                if(word1.charAt(r - 1) == word2.charAt(c - 1)) dp[r][c] = dp[r - 1][c - 1];
                else dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
