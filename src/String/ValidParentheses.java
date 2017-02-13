package String;

import java.util.Stack;

/**
 * Created by Lin on 2017/2/12.
 */
public class ValidParentheses {
    /**
     * Given a String s, containing just the characters '(', ')', '{', '}', '[' and ']',
     * the method is to determine whether s is valid.
     *
     * @see <a href="https://leetcode.com/problems/valid-parentheses/">LeetCode</a>
     *
     * @param s A string containing just the characters '(', ')', '{', '}', '[' and ']'
     * @return True if s is parentheses, else false
     */
    public boolean isValidParentheses(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(' || cur == '{' || cur == '[') stack.push(cur);
            else{
                if(stack.isEmpty()) return false;
                if(cur == ')' && stack.pop() != '(') return false;
                else if(cur == '}' && stack.pop() != '{') return false;
                else if(cur == ']' && stack.pop() != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
