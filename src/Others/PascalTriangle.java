package Others;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/7/8.
 */
public class PascalTriangle {
    /**
     * Given numRows, generate the first numRows of Pascal's triangle.
     *
     * @see <a href="https://leetcode.com/problems/pascals-triangle/#/description">LintCode</a>
     *
     * @param numRows An Integer
     * @return The first numRows of Pascal's triangle
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) list.add(1);
                else list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }

            res.add(list);
        }

        return res;
    }
}
