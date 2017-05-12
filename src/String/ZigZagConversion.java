package String;

/**
 * Created by Lin on 2017/5/12.
 */
public class ZigZagConversion {
    /**
     * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/#/description">LeetCode</a>
     * Write the code that will take a string and make this conversion given a number of rows
     *
     * @param s A given string
     * @param numRows A given integer
     * */
    public String convert(String s, int numRows) {
        // corner case
        if(numRows == 1) return s;

        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < numRows; row++){
            int i = row;
            boolean flag = false;
            while(i < s.length()){
                sb.append(s.charAt(i));
                int add = flag ? 2*row : 2*(numRows - row - 1);
                if(add == 0) add = 2*(numRows - 1);
                flag = !flag;
                i += add;
            }
        }

        return sb.toString();
    }
}
