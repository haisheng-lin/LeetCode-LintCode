package String;

/**
 * Created by Lin on 2017/2/12.
 */
public class IsAnagram {
    /**
     * @see <a href="https://leetcode.com/problems/valid-anagram/">LeetCode</a>
     *
     * @param s A String
     * @param t A String
     * @return True if s and t is anagram, else false
     */
    public boolean isAnagram(String s, String t){
        // corner case
        if(s.length() != t.length()) return false;
        int[] chars = new int[128];
        for(int i = 0; i < s.length(); i++) chars[s.charAt(i)]++;
        for(int i = 0; i < t.length(); i++) chars[t.charAt(i)]--;
        // check
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != 0) return false;
        }

        return true;
    }
}
