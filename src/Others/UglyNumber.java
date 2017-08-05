package Others;

/**
 * Created by Lin on 2017/8/3.
 */
public class UglyNumber {
    /**
     * Write a program to check whether a given number is an ugly number.
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     *
     * @see <a href="https://leetcode.com/problems/ugly-number">LeetCode</a>
     *
     * @param num An integer
     * @return True if num is ugly number, else false
     */
    public boolean isUgly(int num) {

        // corner case
        if(num == 0) return false;

        int[] prime = {2, 3, 5};
        for(int i = 0; i < prime.length;){
            if(num % prime[i] == 0) num /= prime[i];
            else i++;
        }

        return num == 1;
    }
}
