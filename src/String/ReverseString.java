package String;

/**
 * Created by Lin on 2017/8/17.
 */
public class ReverseString {
    /**
     * Write a function that takes a string as input and returns the string reversed.
     *
     * @see <a href="https://leetcode.com/problems/reverse-string/">LeetCode</a>
     *
     * @param s String
     * @return Reversed string
     */
    public String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}
