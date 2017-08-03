package Design;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Created by Lin on 2017/7/31.
 */
public class ImplementQueueUsingStacks {

    /** @see <a href="https://leetcode.com/problems/implement-queue-using-stacks">LeetCode</a> */

    Deque<Integer> input, output;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        if(output.isEmpty()){
            while(!input.isEmpty()) output.push(input.pop());
        }

        return output.pop();
    }

    /** Get the front element. */
    public int peek() {

        if(output.isEmpty()){
            while(!input.isEmpty()) output.push(input.pop());
        }

        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
