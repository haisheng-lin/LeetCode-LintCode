package Recursion;

/**
 * Created by Lin on 2017/8/25.
 */
public class TwoKeysKeyboard {
    /**
     * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
     * (1) Copy All: You can copy all the characters present on the notepad (partial copy is not allowed)
     * (2) Paste: You can paste the characters which are copied last time
     *
     * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted
     * Output the minimum number of steps to get n 'A'
     *
     * @see <a href="https://leetcode.com/problems/2-keys-keyboard/">LeetCode</a>
     *
     * @param n Integer
     * @return Minimal number of steps to get n 'A'
     */
    public int minSteps(int n) {

        if(n == 0 || n == 1) return 0;

        int maxMultiplier = findMaxMultiplier(n);
        int minMultiplier = n / maxMultiplier;

        return minSteps(maxMultiplier) + minMultiplier;
    }

    private int findMaxMultiplier(int n) {

        for(int i = n / 2; i > 1; i--) {
            if(n % i == 0) return i;
        }

        return 1;
    }
}
