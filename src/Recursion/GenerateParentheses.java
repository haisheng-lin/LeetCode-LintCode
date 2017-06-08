package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/6/8.
 */
public class GenerateParentheses {

    final char leftChar = '(', rightChar = ')';

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * @see <a href="https://leetcode.com/problems/generate-parentheses/#/description">LintCode</a>
     *
     * @param n An Integer.
     * @return List that contains string with n pairs of parentheses.
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, 0, new StringBuilder());

        return res;
    }

    private void dfs(List<String> res, int left, int right, StringBuilder sb){
        // terminate case
        if(left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }

        if(left > 0){
            StringBuilder sbNext = new StringBuilder(sb);
            sbNext.append(leftChar);
            dfs(res, left - 1, right + 1, sbNext);
        }

        if(right > 0){
            StringBuilder sbNext = new StringBuilder(sb);
            sbNext.append(rightChar);
            dfs(res, left, right - 1, sbNext);
        }
    }
}
