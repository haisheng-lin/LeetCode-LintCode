package String;

/**
 * Created by Lin on 2017/8/20.
 */
public class PalindromicSubstrings {

    int count = 0;

    /**
     * Given a string, your task is to count how many palindromic substrings in this string
     *
     * @see <a href="https://leetcode.com/problems/palindromic-substrings/">LeetCode</a>
     *
     * @param s String
     * @return Number of palindromic substrings
     */
    public int countSubstrings(String s) {

        for(int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }

        return count;
    }

    private void extendPalindrome(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }
}
