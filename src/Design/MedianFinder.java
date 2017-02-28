package Design;

import java.util.Queue;
import java.util.PriorityQueue;

/**
 * Created by Lin on 2017/2/12.
 */
public class MedianFinder {
    /**
     * @see <a href="https://leetcode.com/problems/find-median-from-data-stream/">LeetCode</a>
     * @see <a href="https://discuss.leetcode.com/topic/6613/java-hashtable-double-linked-list-with-a-touch-of-pseudo-nodes">LeetCode</a>
     */

    // long : prevent data overflow
    Queue<Long> small, large;

    // Constructor
    public MedianFinder(){
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }

    public void addNum(int num){
        large.add((long)num);
        // -large.poll() may cause overflow
        small.add(-large.poll());
        if(large.size() < small.size()) large.add(-small.poll());
    }

    public double findMedian(){
        return (large.size() == small.size()) ? (large.peek() - small.peek() / 2.0) : large.peek();
    }
}
