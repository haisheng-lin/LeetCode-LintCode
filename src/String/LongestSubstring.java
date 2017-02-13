package String;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/2/12.
 */
public class LongestSubstring {
    /**
     * @see <a href="http://www.lintcode.com/en/problem/longest-substring-without-repeating-characters/">LintCode</a>
     *
     * @param s A String
     * @return An Integer, the length of longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s){
        int length = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)) start = Math.max(start, map.get(cur) + 1);
            map.put(cur, i);
            length = Math.max(length, i - start + 1);
        }

        return length;
    }
}
