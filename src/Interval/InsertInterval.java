package Interval;

import ClassPackage.Interval;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class InsertInterval {
    /**
     * This method is to insert new Interval into given list and merge interval if necessary.
     *
     * @see <a href="https://leetcode.com/problems/insert-interval/">LeetCode</a>
     *
     * @param intervals a set of non-overlapping intervals, initially sorted according to their start times
     * @param newInterval to be inserted
     * @return void
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // create empty list as result
        List<Interval> res = new ArrayList<>();
        // index for insertion
        int insertPos = 0;
        // new Interval to be inserted or merged
        int start = newInterval.start, end = newInterval.end;
        // loop for each interval
        for(int i = 0; i < intervals.size(); i++){
            // non-overlapping
            if(intervals.get(i).start > end){
                res.add(intervals.get(i));
            }
            else if(intervals.get(i).end < start){
                res.add(intervals.get(i));
                insertPos++;
            }
            // overlapping
            else{
                start = Math.min(start, intervals.get(i).start);
                end = Math.max(end, intervals.get(i).end);
            }
        }
        // insert new Interval
        res.add(insertPos, new Interval(start, end));
        // return result
        return res;
    }
}
