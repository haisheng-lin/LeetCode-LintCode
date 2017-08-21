package Greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lin on 2017/8/21.
 */
public class BrickWall {
    /**
     * @see <a href="https://leetcode.com/problems/brick-wall/">LeetCode</a>
     *
     * @param wall List
     * @return Least number of bricks that needed to cut through
     */
    public int leastBricks(List<List<Integer>> wall) {

        // corner case
        if(wall.isEmpty()) return 0;

        int res = wall.size();
        int total = 0;
        for(int i = 0; i < wall.get(0).size(); i++) total += wall.get(0).get(i);

        int height = wall.size();
        Map<Integer, Integer> map = new HashMap<>();

        for(List<Integer> row: wall) {
            int curSum = 0;
            for(int width: row) {
                curSum += width;
                map.put(curSum, map.getOrDefault(curSum, 0) + 1);
            }
        }

        map.remove(total);

        for(int key: map.keySet()) {
            res = Math.min(res, height - map.get(key));
        }

        return res;
    }
}
