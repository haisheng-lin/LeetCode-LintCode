package String;

/**
 * Created by Lin on 2017/2/14.
 */
public class ValidPalindrome {
    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * @see <a href="https://leetcode.com/problems/valid-palindrome/">LintCode</a>
     *
     * @param s A String
     * @return True if string is a palindrome, else false
     */
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end){
            // find the next alphanumeric character
            while(start < end && !isAlphanumeric(s.charAt(start))) start++;
            while(start < end && !isAlphanumeric(s.charAt(end))) end--;
            // check if the character is the same
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            // next loop
            start++;
            end--;
        }

        return true;
    }

    /**
     * @param c A char
     * @return True if c is alphanumeric, else false
     */
    private boolean isAlphanumeric(char c){
        // alphabetic
        if((65 <= c && c <= 90) || (97 <= c && c <= 122)) return true;
        // numeric
        if(48 <= c && c <= 57) return true;

        return false;
    }
}
