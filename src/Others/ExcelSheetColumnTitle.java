package Others;

/**
 * Created by Lin on 2017/7/25.
 */
public class ExcelSheetColumnTitle {
    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     *
     * @see <a href="https://leetcode.com/problems/excel-sheet-column-title/#/description">LeetCode</a>
     *
     * @param n Integer
     * @return Corresponding column title as appear in an Excel sheet
     */
    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();

        while(n > 0){
            int x = n % 26;
            if(x == 0){
                sb.append('Z');
                n = n / 26 - 1;
            }else{
                sb.append((char)('A' + x - 1));
                n /= 26;
            }
        }

        return sb.reverse().toString();
    }
}
