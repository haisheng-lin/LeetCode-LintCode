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

        List<Interval> res = new ArrayList<>();

        // 插入的位置
        int insertPos = 0;

        // 新的Interval的start以及end
        int start = newInterval.start, end = newInterval.end;

        for(Interval interval: intervals){
            // case 1
            if(interval.end < start){
                res.add(interval);
                insertPos++;
            }
            // case 2
            else if(interval.start > end){
                res.add(interval);
            }
            // case 3
            else{
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
            }
        }

        // 插入新的Interval
        res.add(insertPos, new Interval(start, end));

        return res;
    }
}
