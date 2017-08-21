package Others;

/**
 * Created by Lin on 2017/8/20.
 */
public class SumOfSquareNumbers {
    /**
     * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.
     *
     * @see <a href="https://leetcode.com/problems/sum-of-square-numbers/">LeetCode</a>
     *
     * @param c Integer
     * @return True if c is the sum of two squares, else false
     */
    public boolean judgeSquareSum(int c) {

        if(c < 0) return false;

        for(int i = 0; i <= (int)Math.sqrt(c); i++) {
            int j = (int)Math.sqrt(c - i * i);
            if(i*i + j*j == c) return true;
        }

        return false;
    }
}
