package Others;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/7/8.
 */
public class Triangle {
    /**
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
     *
     * @see <a href="https://leetcode.com/problems/triangle/#/description">LintCode</a>
     *
     * @param triangle An ArrayList
     * @return Minimum path sum from top to bottom
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int res = Integer.MAX_VALUE;
        List<Integer> preLevel = new ArrayList<>();

        for(int i = 0; i < triangle.size(); i++){
            List<Integer> curLevel = new ArrayList<>();
            for(int j = 0; j < triangle.get(i).size(); j++){
                // case 1
                if(i == 0) curLevel.add(triangle.get(i).get(j));

                // case 2
                else if(j == 0) curLevel.add(preLevel.get(j) + triangle.get(i).get(j));

                // case 3
                else if(j == triangle.get(i).size() - 1) curLevel.add(preLevel.get(j - 1) + triangle.get(i).get(j));

                // case 4
                else{
                    int min = Math.min(preLevel.get(j - 1) + triangle.get(i).get(j), preLevel.get(j) + triangle.get(i).get(j));
                    curLevel.add(min);
                }
            }

            preLevel = curLevel;
        }

        for(int val: preLevel) res = Math.min(res, val);

        return res;
    }
}
