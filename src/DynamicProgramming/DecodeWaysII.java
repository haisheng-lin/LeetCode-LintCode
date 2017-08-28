package DynamicProgramming;

/**
 * Created by Lin on 2017/8/27.
 */
public class DecodeWaysII {
    /**
     * @see <a href="https://leetcode.com/problems/decode-ways-ii/">LeetCode</a>
     *
     * @param s Encoded string
     * @return the total number of ways to decode the string
     */
    public int numDecodings(String s) {

        if(s.length() == 0 || s.charAt(0) == '0') return 0;

        long[] dp = new long[s.length() + 1];
        int num = (int)(Math.pow(10, 9) + 7);
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;

        for(int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == '0') {
                if(s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') return 0;
                else if(s.charAt(i - 1) == '*') dp[i + 1] = 2 * dp[i - 1];
                else dp[i + 1] = dp[i - 1];
            } else if('1' <= cur && cur <= '6'){
                if(s.charAt(i - 1) == '*') dp[i + 1] = 2 * dp[i - 1] + dp[i];
                else if(s.charAt(i - 1) == '0') dp[i + 1] = dp[i];
                else if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') dp[i + 1] = dp[i - 1] + dp[i];
                else dp[i + 1] = dp[i];
            } else if('7' <= cur && cur <= '9') {
                if(s.charAt(i - 1) == '*') dp[i + 1] = dp[i - 1] + dp[i];
                else if(s.charAt(i - 1) == '0') dp[i + 1] = dp[i];
                else if(s.charAt(i - 1) == '1') dp[i + 1] = dp[i - 1] + dp[i];
                else dp[i + 1] = dp[i];
            } else {
                if(s.charAt(i - 1) == '*') dp[i + 1] = 15 * dp[i - 1] + 9 * dp[i];
                else if(s.charAt(i - 1) == '0') dp[i + 1] = 9 * dp[i];
                else if(s.charAt(i - 1) == '1') dp[i + 1] = 9 * dp[i - 1] + 9 * dp[i];
                else if(s.charAt(i - 1) == '2') dp[i + 1] = 6 * dp[i - 1] + 9 * dp[i];
                else dp[i + 1] = 9 * dp[i];
            }

            dp[i + 1] = dp[i + 1] % num;
        }

        return (int)dp[s.length()];
    }
}
