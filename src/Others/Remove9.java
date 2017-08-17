package Others;

/**
 * Created by Lin on 2017/8/17.
 */
public class Remove9 {
    /**
     * 9 -> 10
     *
     * @see <a href="https://leetcode.com/problems/remove-9/">LeetCode</a>
     *
     * @param n Integer
     * @return Base 7 string representation
     */
    public int newInteger(int n) {

        int res = 0;
        int base = 1;
        while(n > 0) {
            res += n % 9 * base;
            n /= 9;
            base *= 10;
        }

        return res;
    }
}
