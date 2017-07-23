package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lin on 2017/7/23.
 */
public class IsIsomorphic {
    /**
     * Given two strings s and t, determine if they are isomorphic.
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     *
     * @see <a href="https://leetcode.com/problems/isomorphic-strings/#/description">LeetCode</a>
     *
     * @param s String
     * @param t String
     * @return True if s and t are isomorphic, else false
     */
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1) != c2) return false;
            } else {
                if(map.containsValue(c2)) return false;
                map.put(c1, c2);
            }
        }

        return true;
    }
}
