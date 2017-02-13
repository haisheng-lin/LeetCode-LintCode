package String;

/**
 * Created by Lin on 2017/2/12.
 */
public class StrStr {
    /**
     * @see <a href="https://leetcode.com/problems/implement-strstr/">LeetCode</a>
     *
     * @param s A String
     * @param t A String
     * @return An Integer, first index of t in s. return -1 if t does not exist in s
     */
    public int strStr(String s, String t){
        if(s == null || t == null) return -1;
        return s.indexOf(t);
    }
}
