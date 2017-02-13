package String;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/2/12.
 */
public class GroupAnagrams {
    /**
     * This method is used to group anagrams together from a given array of strings.
     *
     * @see <a href="https://leetcode.com/problems/anagrams/">LintCode</a>
     *
     * @param strs An array of String
     * @return List of grouped anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String model = new String(charArray);
            List<String> list = new ArrayList<>();
            if(map.containsKey(model)) list = map.get(model);
            list.add(str);
            map.put(model, list);
        }

        for(String model : map.keySet()){
            res.add(map.get(model));
        }

        return res;
    }
}
