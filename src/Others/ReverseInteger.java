package Others;

/**
 * Created by Lin on 2017/5/12.
 */
public class ReverseInteger {
    /**
     * @see <a href="https://leetcode.com/problems/reverse-integer/#/description">LeetCode</a>
     *
     * @param x An integer
     * @return reverse of x
     */
    public int reverse(int x) {
        // corner case
        if(x == Integer.MIN_VALUE) return 0;

        int res = 0;
        int num = (x < 0) ? -x : x;
        while(num > 0){
            int temp = res * 10 + (num % 10);
            // check overflow
            if(res != (temp - (num % 10)) / 10) return 0;

            res = temp;
            num /= 10;
        }

        return (x < 0) ? -res : res;
    }
}
