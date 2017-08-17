package Others;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lin on 2017/8/17.
 */
public class PerfectNumber {
    /**
     * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
     * Given an integer n, write a function that returns true when it is a perfect number and false when it is not.
     *
     * @see <a href="https://leetcode.com/problems/perfect-number/">LeetCode</a>
     *
     * @param num Integer
     * @return True when it is a perfect number and false when it is not
     */
    public boolean checkPerfectNumber(int num) {

        if(num <= 1) return false;

        Set<Integer> divisors = new HashSet<>();
        for(int i = 1; i * i <= num; i++) {
            if(num % i == 0) {
                divisors.add(i);
                if(num / i != num) divisors.add(num / i);
            }
        }

        for(int divisor: divisors) num -= divisor;
        return num == 0;
    }
}
