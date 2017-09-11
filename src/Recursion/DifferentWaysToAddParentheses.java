package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 2017/9/11.
 */
public class DifferentWaysToAddParentheses {
    /**
     * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *
     *
     * @see <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">LeetCode</a>
     *
     * @param input String
     * @return All possible results from computing all the different possible ways to group numbers and operators
     */
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if(cur == '+' || cur == '-' || cur == '*') {

                String str1 = input.substring(0, i);
                String str2 = input.substring(i + 1, input.length());

                List<Integer> list1 = diffWaysToCompute(str1);
                List<Integer> list2 = diffWaysToCompute(str2);

                for(int num1: list1) {
                    for(int num2: list2) {
                        if(cur == '+') res.add(num1 + num2);
                        else if(cur == '-') res.add(num1 - num2);
                        else res.add(num1 * num2);
                    }
                }
            }
        }

        if(res.isEmpty()) res.add(Integer.valueOf(input));

        return res;
    }
}
