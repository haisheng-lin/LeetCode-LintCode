package String;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/2/12.
 */
public class Anagrams {
    /**
     * This method is used to find all groups of strings that are anagrams, given an array of strings.
     *
     * @see <a href="http://www.lintcode.com/en/problem/anagrams/">LintCode</a>
     *
     * @param strs An array of String
     * @return List of words that have anagrams
     */
    public List<String> anagrams(String[] strs){
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String model = new String(charArray);

            List<String> list = new ArrayList<>();
            if(map.containsKey(model)) list = map.get(model);
            list.add(s);
            map.put(model, list);
        }
        for(String key : map.keySet()){
            List<String> list = map.get(key);
            if(list.size() > 1) res.addAll(list);
        }

        return res;
    }
}
