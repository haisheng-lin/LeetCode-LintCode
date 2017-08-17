package Others;

/**
 * Created by Lin on 2017/8/17.
 */
public class Base7 {
    /**
     * 10 -> 7
     *
     * Given an integer, return its base 7 string representation.
     *
     * @see <a href="https://leetcode.com/problems/base-7/">LeetCode</a>
     *
     * @param num Integer
     * @return Base 7 string representation
     */
    public String convertToBase7(int num) {

        if(num == Integer.MIN_VALUE) return "0";

        int res = 0;
        int base = 1;

        while(num != 0) {
            res +=  num % 7 * base;
            num /= 7;
            base *= 10;
        }

        return String.valueOf(res);
    }
}
