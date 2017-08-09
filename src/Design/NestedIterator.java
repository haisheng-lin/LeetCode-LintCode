package Design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ClassPackage.NestedInteger;

/**
 * Created by Lin on 2017/8/9.
 */
public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        helper(nestedList);
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void helper(List<NestedInteger> nestedList){

        for(NestedInteger nestedInteger: nestedList){
            if(nestedInteger.isInteger()) queue.offer(nestedInteger.getInteger());
            else helper(nestedInteger.getList());
        }
    }
}
