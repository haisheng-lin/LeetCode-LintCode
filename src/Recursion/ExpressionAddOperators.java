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
        if(num.length() > 0) dfs(res, num, target, 0, new StringBuilder());

        return res;
    }

    private void dfs(List<String> res, String num, int target, int depth, StringBuilder sb) {

        // corner case
        if(depth == num.length() - 1) {
            sb.append(num.charAt(depth));
            if(getNum(sb) == target){
                res.add(sb.toString());
            }
            return;
        }

        StringBuilder curSb = new StringBuilder(sb);
        curSb.append(num.charAt(depth));

        // Case 1: 如果字符为'0'且为前缀，不能与后面的数字结合，所以必须加操作符
        StringBuilder sb1 = new StringBuilder(curSb);
        sb1.append('+');
        dfs(res, num, target, depth + 1, sb1);

        StringBuilder sb2 = new StringBuilder(curSb);
        sb2.append('-');
        dfs(res, num, target, depth + 1, sb2);

        StringBuilder sb3 = new StringBuilder(curSb);
        sb3.append('*');
        dfs(res, num, target, depth + 1, sb3);

        // Case 2: 否则，可不加操作符
        if(num.charAt(depth) != '0' || (sb.length() > 0 && Character.isDigit(sb.charAt(sb.length() - 1)))) {
            StringBuilder sb4 = new StringBuilder(curSb);
            dfs(res, num, target, depth + 1, sb4);
        }
    }

    private int getNum(StringBuilder s) {

        int len;
        if(s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign == '-') stack.push(-num);
                if(sign == '+') stack.push(num);
                if(sign == '*') stack.push(stack.pop() * num);
                if(sign=='/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i : stack) re += i;

        return re;
    }
}
