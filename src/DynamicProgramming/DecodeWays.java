package DynamicProgramming;

/**
 * Created by Lin on 2017/7/3.
 */
public class DecodeWays {
    /**
     * @see <a href="https://leetcode.com/problems/decode-ways/#/description">LeetCode</a>
     *
     * @param s Encoded string
     * @return the total number of ways to decode the string
     */
    public int numDecodings(String s) {

        // corner case
        if(s.length() == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == '0'){
                // no way to decode
                if(s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') return 0;
                dp[i + 1] = dp[i - 1];
            }

            else{
                if(i - 1 < 0) dp[i + 1] = 1;
                else{
                    int val = 10 * (s.charAt(i - 1) - 48) + (s.charAt(i) - 48);
                    if(s.charAt(i - 1) == '0' || val > 26) dp[i + 1] = dp[i];
                    else dp[i + 1] = dp[i] + dp[i - 1];
                }
            }
        }

        return dp[s.length()];
    }
}
