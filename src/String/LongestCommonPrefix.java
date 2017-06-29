package String;

/**
 * Created by Lin on 2017/2/12.
 */
public class LongestCommonPrefix {
    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * @see <a href="https://leetcode.com/problems/longest-common-prefix/">LeetCode</a>
     *
     * @param strs An array of String
     * @return A String, longest common prefix
     */
    public String longestCommonPrefix(String[] strs){
        // corner case
        if(strs == null || strs.length == 0) return "";

        StringBuilder sb = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++){
            int length = Math.min(sb.length(), strs[i].length());
            int index = 0;
            while(index < length){
                if(sb.charAt(index) != strs[i].charAt(index)) break;
                index++;
            }
            sb.delete(index, sb.length());
        }

        return sb.toString();
    }
}
