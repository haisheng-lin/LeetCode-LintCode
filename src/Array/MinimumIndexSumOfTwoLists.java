package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lin on 2017/8/18.
 */
public class MinimumIndexSumOfTwoLists {
    /**
     * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings
     * Find out their common interest with the least list index sum
     * If there is a choice tie between answers, output all of them with no order requirement
     *
     * @see <a href="https://leetcode.com/problems/minimum-index-sum-of-two-lists/">LeetCode</a>
     *
     * @param list1 A string array
     * @param list2 A string array
     * @return Common interest with the least list index sum
     */
    public String[] findRestaurant(String[] list1, String[] list2) {

        List<String> list = new ArrayList<>();

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i = 0; i < list1.length; i++) map1.put(i, list1[i]);
        for(int i = 0; i < list2.length; i++) map2.put(list2[i], i);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++){
            String restaurant = list1[i];
            if(map2.containsKey(restaurant)){
                min = Math.min(min, i + map2.get(restaurant));
            }
        }

        for(int i = 0; i < list1.length; i++){
            String restaurant = list1[i];
            if(map2.containsKey(restaurant) && i + map2.get(restaurant) == min){
                list.add(restaurant);
            }
        }

        String[] res = new String[list.size()];
        res = list.toArray(res);

        return res;
    }
}
