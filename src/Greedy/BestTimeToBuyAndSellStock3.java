package Greedy;

/**
 * Created by Lin on 2017/7/10.
 */
public class BestTimeToBuyAndSellStock3 {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * However, you may not engage in multiple transactions at the same time
     *
     * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/#/description">LeetCode</a>
     *
     * @param prices An Integer array
     * @return Maximum profit
     */
    public int maxProfit(int[] prices) {

        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;

        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }

        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}
