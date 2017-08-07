package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by Lin on 2017/8/6.
 */
public class CoinChange {
    /**
     * Given coins of different denominations and a total amount of money amount
     * Write a function to compute the fewest number of coins that you need to make up that amount
     *
     * @see <a href="https://leetcode.com/problems/coin-change/">LeetCode</a>
     *
     * @param coins An integer array
     * @param amount An integer
     * @return The fewest number of coins that make up the amount
     */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.sort(coins);

        for(int i = 1; i <= amount; i++){

            int min = -1;
            for(int j = 0; j < coins.length && coins[j] <= i; j++){
                if(dp[i - coins[j]] >= 0) min = (min == -1) ? dp[i - coins[j]] + 1 : Math.min(min, dp[i - coins[j]] + 1);
            }

            dp[i] = min;
        }

        return dp[amount];
    }
}
