package Interval;

import ClassPackage.Interval;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Lin on 2017/2/12.
 */
public class MergeInterval {
    /**
     * @see <a href="https://leetcode.com/problems/merge-intervals/">LeetCode</a>
     *
     * @param intervals A collection of intervals
     * @return A new sorted interval list
     */
    public List<Interval> merge(List<Interval> intervals){
        // corner case
        if(intervals == null || intervals.isEmpty()) return new ArrayList<>();
        // create empty list as result
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                if(i1.start == i2.start) return i1.end - i2.end;
                return i1.end - i2.end;
            }
        });
        // merge intervals
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for(Interval interval : intervals){
            // non-overlapping
            if(interval.start > end){
                res.add(new Interval(start, end));
                // reset
                start = interval.start;
                end = interval.end;
            }
            // overlapping
            else end = Math.max(end, interval.end);
        }
        res.add(new Interval(start, end));
        // return result
        return res;
    }
}
