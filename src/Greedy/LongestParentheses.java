package Greedy;

import java.util.Stack;

/**
 * Created by Lin on 2017/2/12.
 */
public class LongestParentheses {
    /**
     * @see <a href="https://leetcode.com/problems/longest-valid-parentheses/">LeetCode</a>
     *
     * @param s A String
     * @return An Integer, longest length of valid parentheses
     */
    public int longestValidParentheses(String s) {
        int length = 0;
        Stack<Integer> stack = new Stack<>();
        int start = -1;//start为上一个不合法的字符位置
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push(i);
            else{
                if(stack.isEmpty()) start = i;
                else{
                    stack.pop();
                    if(stack.isEmpty()) length = Math.max(length,i-start);//如果栈为空,start到i的子串都是合法
                    else length = Math.max(length,i-stack.peek());//如果栈不为空,start到i的子串部分合法,如(()里()才是合法
                }
            }
        }
        return length;
    }
}
