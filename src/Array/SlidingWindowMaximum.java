package Array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Lin on 2017/9/11.
 */
public class SlidingWindowMaximum {
    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window
     * Each time the sliding window moves right by one position
     * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array
     *
     * @see <a href="https://leetcode.com/problems/sliding-window-maximum/">LeetCode</a>
     *
     * @param nums Integer array
     * @param k Integer
     * @return Maximum number of all sliding windows
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int ri = 0;

        for(int i = 0; i < nums.length; i++) {

            while(!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();

            deque.offer(i);
            if(i >= k - 1) res[ri++] = nums[deque.peek()];
        }

        return res;
    }
}
