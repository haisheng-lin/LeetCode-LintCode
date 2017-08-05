package String;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/8/4.
 */
public class WordPattern {
    /**
     * Given a pattern and a string str, find if str follows the same pattern.
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
     * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
     *
     * @see <a href="https://leetcode.com/problems/word-pattern/">LeetCode</a>
     *
     * @param pattern An array of integers
     * @param str A string
     * @return Duplicate number
     */
    public boolean wordPattern(String pattern, String str) {

        Map<Character, String> map = new HashMap<>();
        String[] words = str.split(" ");

        // check length
        if(pattern.length() != words.length) return false;

        for(int i = 0; i < pattern.length(); i++){

            char key = pattern.charAt(i);
            String word = words[i];

            // 检查一对多映射
            if(map.containsKey(key) && !map.get(key).equals(word)) return false;

            // 检查多对一映射
            if(!map.containsKey(key) && map.containsValue(word)) return false;

            // 建立映射关系
            map.put(key, word);
        }

        return true;
    }
}
