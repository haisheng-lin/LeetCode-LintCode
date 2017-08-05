package Design;


import java.util.Iterator;

/**
 * Created by Lin on 2017/8/4.
 */
public class PeekingIterator implements Iterator<Integer> {

    /** @see <a href="https://leetcode.com/problems/peeking-iterator/">LeetCode</a> */

    private Iterator<Integer> iter;
    private Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if(iter.hasNext()) next = iter.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
