package Others;

/**
 * Created by Lin on 2017/6/28.
 */
public class UniquePaths {
    /**
     * How many possible unique paths are there?
     *
     * @see <a href="https://leetcode.com/problems/unique-paths/#/description">LeetCode</a>
     *
     * @param m Integer, row number
     * @param n Integer, column number
     * @return Number of unique paths
     */
    public int uniquePaths(int m, int n) {

        int res = 1;

        int temp1 = m, temp2 = n;
        m = Math.max(temp1, temp2);
        n = Math.min(temp1, temp2);

        for(int i = m, j = 1; i <= m+n-2 && j <= n-1; i++, j++){
            int gcd = greatestCommonDivisor(i, j);
            int dividend = i / gcd, divisor = j / gcd;
            res /= divisor;
            res *= dividend;
        }

        return res;
    }

    private int greatestCommonDivisor(int m, int n){
        int max = Math.max(m, n), min = Math.min(m, n);
        if(max % min == 0) return min;
        return greatestCommonDivisor(min, max % min);
    }
}
