package BinarySearch;

/**
 * Created by Lin on 2017/8/13.
 */
public class ValidPerfectSquare {
    /**
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
     *
     * @see <a href="https://leetcode.com/problems/valid-perfect-square/">LeetCode</a>
     *
     * @param num An integer.
     * @return True if num is perfect square, else false
     */
    public boolean isPerfectSquare(int num) {

        if(num < 0) return false;
        if(num == 0) return true;

        int left = 1, right = 46340;
        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            if(mid * mid < num) left = mid;
            else if(mid * mid > num) right = mid;
            else return true;
        }

        return left * left == num || right * right == num;
    }
}
