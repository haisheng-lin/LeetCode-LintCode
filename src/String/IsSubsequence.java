package String;

/**
 * Created by Lin on 2017/8/14.
 */
public class IsSubsequence {
    /**
     * Given a string s and a string t, check if s is subsequence of t.
     *
     * @see <a href="https://leetcode.com/problems/is-subsequence/">LeetCode</a>
     *
     * @param s String
     * @param t String
     * @return True if s is subsequence of t, else false
     */
    public boolean isSubsequence(String s, String t) {

        int last = -1;
        for(int i = 0; i < s.length(); i++) {
            int index = t.indexOf(s.charAt(i), last + 1);
            if(index < 0) return false;
            last = index;
        }

        return true;
    }
}
