package BinaryTree;

/**
 * Created by Lin on 2017/7/4.
 */
public class UniqueBSTs {
    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
     *
     * @see <a href="https://leetcode.com/problems/unique-binary-search-trees/#/description">LeetCode</a>
     *
     * @param n An integer
     * @return number of unique BST's
     */
    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            int res = 0;
            for(int j = 1; j <= i; j++){
                res += dp[j - 1] * dp[i - j];
            }

            dp[i] = res;
        }

        return dp[n];
    }

    /**
     * Time Limit Exceeded
     */
    public int numTrees2(int n) {
        return helper(1, n);
    }

    private int helper(int start, int end){
        // corner case
        if(start >= end) return 1;

        int count = 0;
        for(int i = start; i <= end; i++){
            int left = helper(start, i - 1), right = helper(i + 1, end);
            count += left * right;
        }

        return count;
    }
}
