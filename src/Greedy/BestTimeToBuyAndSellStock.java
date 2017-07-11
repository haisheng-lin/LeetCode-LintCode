package Greedy;

/**
 * Created by Lin on 2017/7/9.
 */
public class BestTimeToBuyAndSellStock {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description">LeetCode</a>
     *
     * @param prices An Integer array
     * @return Maximum profit
     */
    public int maxProfit(int[] prices) {

        int res = 0;
        int min = Integer.MAX_VALUE;

        for(int num: prices){
            min = Math.min(min, num);
            res = Math.max(res, num - min);
        }

        return res;
    }
}
