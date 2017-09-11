package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lin on 2017/9/11.
 */
public class PalindromePairs {
    /**
     * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome
     *
     * @see <a href="https://leetcode.com/problems/palindrome-pairs/">LeetCode</a>
     *
     * @param words String array
     * @return All pairs distinct indices
     */
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j <= words[i].length(); j++) {

                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);

                if(isPalindromic(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        res.add(list);
                    }
                }

                if(isPalindromic(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() > 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }

    private boolean isPalindromic(String s) {

        int start = 0, end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}
