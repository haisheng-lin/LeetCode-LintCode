package String;

/**
 * Created by Lin on 2017/8/17.
 */
public class ReverseStringII {
    /**
     * Given a string and an integer k
     * Reverse the first k characters for every 2k characters counting from the start of the string
     * If there are less than k characters left, reverse all of them
     * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original
     *
     * @see <a href="https://leetcode.com/problems/reverse-string-ii/">LeetCode</a>
     *
     * @param s String
     * @param k Integer
     * @return Reversed string
     */
    public String reverseStr(String s, int k) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i += 2*k) {

            // Case 1: There are more than 2k characters left
            if(i + 2*k <= s.length()){
                for(int j = i + k - 1; j >= i; j--) sb.append(s.charAt(j));
                for(int j = i + k; j < i + 2*k; j++) sb.append(s.charAt(j));
            }

            // Case 2: There are less than 2k but greater than or equal to k characters
            else if(i + k <= s.length() && i + 2*k > s.length()){
                for(int j = i + k - 1; j >= i; j--) sb.append(s.charAt(j));
                for(int j = i + k; j < s.length(); j++) sb.append(s.charAt(j));
            }

            // Case 3: There are less than k characters
            else{
                for(int j = s.length() - 1; j >= i; j--) sb.append(s.charAt(j));
            }
        }


        return sb.toString();
    }
}
