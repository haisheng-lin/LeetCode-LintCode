package Design;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lin on 2017/8/15.
 */
public class InsertDeleteGetRandom {

    /** @see <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/">LeetCode</a> */

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(map.containsKey(val)) return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if(!map.containsKey(val)) return false;

        int index = map.get(val);

        if(index != list.size() - 1) {
            list.set(index, list.get(list.size() - 1));
            map.put(list.get(list.size() - 1), index);
        }

        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
