package Array;

/**
 * Created by Lin on 2017/8/27.
 */
public class BeautifulArrangementII {
    /**
     * Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
     * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers
     * If there are multiple answers, print any of them
     *
     * @see <a href="https://leetcode.com/problems/beautiful-arrangement-ii/">LeetCode</a>
     *
     * @param n Integer
     * @param k Integer
     * @return Array
     */
    public int[] constructArray(int n, int k) {

        int[] res = new int[n];

        res[0] = 1;
        boolean plus = true;

        for(int i = 1; i < res.length; i++) {
            if(k > 0) {
                res[i] = plus ? res[i - 1] + k : res[i - 1] - k;
                plus = !plus;
                k--;
            } else {
                res[i] = i + 1;
            }
        }

        return res;
    }
}
