package String;

/**
 * Created by Lin on 2017/2/12.
 */
public class LengthOfLastWord {
    /**
     * @see <a href="https://leetcode.com/problems/length-of-last-word/">LeetCode</a>
     *
     * @param s A String
     * @return Length of last word, or 0 if last word does not exist
     */
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return (words.length == 0) ? 0 : words[words.length - 1].length();
    }
}
