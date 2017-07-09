package DynamicProgramming;

import java.util.Set;

/**
 * Created by Lin on 2017/2/12.
 */
public class WordBreak {
    /**
     * @see <a href="https://leetcode.com/problems/word-break/">LeetCode</a>
     *
     * @param s A string
     * @param dict A dictionary of words dictionary
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // special case
        if(s.length() == 0) return true;
        if(dict.isEmpty()) return false;

        boolean[] dp = new boolean[s.length() + 1];

        // 预处理
        dp[0] = true;

        // 状态转移方程式
        for(int i = 1; i <= s.length(); i++){
            for(String word : dict){
                if(i - word.length() >= 0 && s.substring(i - word.length(), i).equals(word) && dp[i - word.length()]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
