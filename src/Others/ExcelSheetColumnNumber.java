package Others;

/**
 * Created by Lin on 2017/7/25.
 */
public class ExcelSheetColumnNumber {
    /**
     * Given a column title as appear in an Excel sheet, return its corresponding column number.
     *
     * @see <a href="https://leetcode.com/problems/excel-sheet-column-title/#/description">LeetCode</a>
     *
     * @param s String representing the column title
     * @return Corresponding column number
     */
    public int titleToNumber(String s) {

        int res = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            char cur = s.charAt(i);
            res += (cur - 64) * Math.pow(26, s.length() - i - 1);
        }

        return res;
    }
}
