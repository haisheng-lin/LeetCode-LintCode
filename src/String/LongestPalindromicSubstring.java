package String;

/**
 * Created by Lin on 2017/2/12.
 */
public class LongestPalindromicSubstring {
    /**
     * Given a string s, find the longest palindromic substring in s.
     *
     * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/">LeetCode</a>
     *
     * @param s A String
     * @return String, longest palindromic substring
     */
    public String longestPalindromicSubstring(String s){
        // greedy algorithm
        String res = "";
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s, i - max - 1, i)){
                res = s.substring(i - max - 1, i + 1);
                max += 2;
            }
            else if(isPalindrome(s, i - max, i)){
                res = s.substring(i - max, i + 1);
                max += 1;
            }
        }

        return res;
    }

    private boolean isPalindrome(String s, int start, int end){
        if(start > end) return false;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}
