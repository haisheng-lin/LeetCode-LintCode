package Interval;

import ClassPackage.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 2017/8/13.
 */
public class DataStreamAsDisjointIntervals {

    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */

    List<Interval> list;

    /** Initialize your data structure here. */
    public DataStreamAsDisjointIntervals() {
        list = new ArrayList<>();
    }

    public void addNum(int val) {

        List<Interval> newList = new ArrayList<>();
        int insertPos = 0;
        int start = val, end = val;

        // flag 表示是否需要插入
        boolean flag = true;

        for(Interval interval: list) {

            // 可延伸
            // Case 1: 接壤
            if(start == interval.end + 1 || end == interval.start - 1) {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
            }
            // Case 2: 部分覆盖
            else if((interval.start <= start && start <= interval.end) || (interval.start <= end && end <= interval.end)) {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
            }

            // 不可延伸
            // Case 1: 完全包含关系
            else if(interval.start < start && end < interval.end) {
                flag = false;
                newList.add(interval);
            }
            // Case 2: 完全没有关系
            else if(end < interval.start){
                newList.add(interval);
            } else if(interval.end < start) {
                insertPos++;
                newList.add(interval);
            }
        }

        if(flag) newList.add(insertPos, new Interval(start, end));
        list = newList;
    }

    public List<Interval> getIntervals() {
        return list;
    }
}
