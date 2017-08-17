package Design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lin on 2017/8/17.
 */
public class ImplementStackUsingQueues {

    /** @see <a href="https://leetcode.com/problems/implement-stack-using-queues/">LeetCode</a> */

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        for(int i = 0; i < queue.size() - 1; i++) queue.offer(queue.poll());
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
