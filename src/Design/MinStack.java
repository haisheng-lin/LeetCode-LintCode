package Design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lin on 2017/7/14.
 */
public class MinStack {

    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     * @see <a href="https://leetcode.com/problems/min-stack/#/description">LeetCode</a>
     */

    Deque<Integer> stack;
    Map<Integer, Integer> map;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        map = new HashMap<>();
        min = Integer.MAX_VALUE;
    }

    /** Push element x onto stack */
    public void push(int x) {
        stack.push(x);
        int num = map.containsKey(x) ? map.get(x) + 1 : 1;
        map.put(x, num);
        min = Math.min(min, x);
    }

    /** Removes the element on top of the stack */
    public void pop() {
        int x = stack.pop();

        if(map.get(x) == 1){
            map.remove(x);
            if(min == x){
                min = Integer.MAX_VALUE;
                for(int key: map.keySet()) min = Math.min(min, key);
            }
        }
        else map.put(x, map.get(x) - 1);
    }

    /** Get the top element */
    public int top() {
        return stack.peek();
    }

    /** Retrieve the minimum element in the stack */
    public int getMin() {
        return min;
    }
}
