package Others;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/15.
 */
public class PascalTriangle2 {
    /**
     * Given an index k, return the kth row of the Pascal's triangle.
     *
     * @see <a href="https://leetcode.com/problems/pascals-triangle-ii/">LintCode</a>
     *
     * @param rowIndex An Integer
     * @return A list, the kth row of the Pascal's triangle.
     */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();

        // initialization
        res.add(1);

        for(int row = 1; row <= rowIndex; row++){
            // 这里i = [1, row - 1]是不对的,因为后面的值受到之前的影响
            for(int i = row - 1; i >= 1; i--){
                int temp = res.get(i - 1) + res.get(i);
                // method learned today
                res.set(i, temp);
            }
            res.add(1);
        }

        return res;
    }
}
