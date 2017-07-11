package Greedy;

/**
 * Created by Lin on 2017/7/9.
 */
public class BestTimeToBuyAndSellStock2 {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
     * However, you may not engage in multiple transactions at the same time
     *
     * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/#/description">LeetCode</a>
     *
     * @param prices An Integer array
     * @return Maximum profit
     */
    public int maxProfit(int[] prices) {

        int res = 0;
        int min = Integer.MAX_VALUE;

        for(int num: prices){
            if(min > num) min = num;
            else{
                res += num - min;
                min = num;
            }
        }

        return res;
    }
}
