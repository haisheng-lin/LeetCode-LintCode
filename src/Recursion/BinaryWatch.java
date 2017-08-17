package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 2017/8/17.
 */
public class BinaryWatch {

    final char split = ':';
    final int[] hours = {1, 2, 4, 8};
    final int[] minutes = {1, 2, 4, 8, 16, 32};

    /**
     * Given a non-negative integer n which represents the number of LEDs that are currently on
     * Return all possible times the watch could represent
     *
     * @see <a href="https://leetcode.com/problems/combinations/">LeetCode</a>
     *
     * @param num Integer which represents the number of LEDs that are currently on
     * @return All possible times the watch could represent
     */
    public List<String> readBinaryWatch(int num) {

        // corner case
        if(num < 0 || num > 10) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        if(num > 4) dfs(res, 4, num - 4);
        else dfs(res, num, 0);

        return res;
    }

    private void dfs(List<String> res, int hour, int minute) {

        // corner case
        if(hour < 0 || hour > 4 || minute < 0 || minute > 6) return;

        List<Integer> hourList = new ArrayList<>(), minuteList = new ArrayList<>();
        getHours(hourList, 0, 0, hour);
        getMinutes(minuteList, 0, 0, minute);

        for(int h: hourList) {
            if(h >= 12) continue;
            for(int m: minuteList) {
                if(m >= 60) continue;
                String hourStr = String.valueOf(h);
                String minStr = m < 10 ? "0" + m : String.valueOf(m);
                res.add(hourStr + split + minStr);
            }
        }

        dfs(res, hour - 1, minute + 1);
    }

    private void getHours(List<Integer> res, int depth, int total, int k) {

        if(k == 0) {
            res.add(total);
            return;
        }

        for(int i = depth; i < hours.length; i++) {
            getHours(res, i + 1, total + hours[i], k - 1);
        }
    }

    private void getMinutes(List<Integer> res, int depth, int total, int k) {

        if(k == 0) {
            res.add(total);
            return;
        }

        for(int i = depth; i < minutes.length; i++) {
            getMinutes(res, i + 1, total + minutes[i], k - 1);
        }
    }
}
