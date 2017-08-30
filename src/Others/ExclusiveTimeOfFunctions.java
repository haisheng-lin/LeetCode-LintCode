package Others;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Created by Lin on 2017/8/30.
 */
public class ExclusiveTimeOfFunctions {
    /**
     * @see <a href="https://leetcode.com/problems/exclusive-time-of-functions/">LeetCode</a>
     *
     * @param n Integer
     * @param logs List
     * @return The exclusive time of each function
     */
    public int[] exclusiveTime(int n, List<String> logs) {

        if (n == 0) return new int[0];

        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        int start = 0;
        boolean isStart = false;

        for (String log : logs) {

            String[] info = log.split(":");
            int id = Integer.valueOf(info[0]), time = Integer.valueOf(info[2]);

            if (info[1].equals("start")) {
                if (!stack.isEmpty()) res[stack.peek()] += isStart ? time - start : time - start - 1;
                stack.push(id);
                start = time;
                isStart = true;
            } else {
                res[stack.pop()] += isStart ? time - start + 1 : time - start;
                start = time;
                isStart = false;
            }
        }

        return res;
    }
}
