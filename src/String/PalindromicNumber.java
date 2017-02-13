package String;

/**
 * Created by Lin on 2017/2/12.
 */
public class PalindromicNumber {
    /**
     * @see <a href="https://leetcode.com/problems/palindrome-number/">LeetCode</a>
     *
     * @param num An Integer
     * @return True if it is palindromic, else false
     */
    public boolean isPalindrome(int num){
        String s = String.valueOf(num);
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}
