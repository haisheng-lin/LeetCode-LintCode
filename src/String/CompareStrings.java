package String;

/**
 * Created by Lin on 2017/2/12.
 */
public class CompareStrings {
    /**
     * Compare two strings A and B, determine whether A contains all of the characters in B.
     * The characters in string A and B are all Upper Case letters.
     *
     * @see <a href="http://www.lintcode.com/en/problem/compare-strings/">LintCode</a>
     *
     * @param s A String
     * @param t A String
     * @return True if s contains all characters of t, else return false
     */
    public boolean conpareStrings(String s, String t){
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++) chars[s.charAt(i) - 65]++;
        for(int i = 0; i < t.length(); i++) chars[t.charAt(i) - 65]--;

        for(int i = 0; i < chars.length; i++){
            if(chars[i] < 0) return false;
        }

        return true;
    }
}
