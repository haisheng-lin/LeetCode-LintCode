package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Lin on 2017/8/14.
 */
public class ExpressionAddOperators {
    /**
     * Given a string that contains only digits 0-9 and a target value,
     * Return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
     *
     * @see <a href="https://leetcode.com/problems/expression-add-operators/">LeetCode</a>
     *
     * @param num String
     * @param target Integer
     * @return All possibilities to add binary operators so they evaluate to the target value
     */
    public List<String> addOperators(String num, int target) {

        List<String> res = new ArrayList<>();
        if(num.length() > 0) helper(res, num, target, "", 0, 0, 0);

        return res;
    }

    private void helper(List<String> res, String num, int target, String path, int depth, long eval, long multed) {

        if(depth == num.length()) {
            if(eval == target) res.add(path);
            return;
        }

        for(int i = depth; i < num.length(); i++) {
            if(num.charAt(depth) == '0' && i != depth) break;
            long cur = Long.parseLong(num.substring(depth, i + 1));
            if(depth == 0) {
                helper(res, num, target, path + cur, i + 1, cur, cur);
            } else {
                helper(res, num, target, path + "+" + cur, i + 1, eval + cur, cur);
                helper(res, num, target, path + "-" + cur, i + 1, eval - cur, -cur);
                helper(res, num, target, path + "*" + cur, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
