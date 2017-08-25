package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Lin on 2017/8/24.
 */
public class CourseScheduleIII {
    /**
     * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day
     * A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day
     * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken
     *
     * @see <a href="https://leetcode.com/problems/course-schedule-iii/">LeetCode</a>
     *
     * @param courses 2D integer array
     * @return Maximal number of courses that can be taken
     */
    public int scheduleCourse(int[][] courses) {

        int timeStamp = 0;

        Arrays.sort(courses, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int[] course: courses) {
            timeStamp += course[0];
            pq.offer(course[0]);
            if(timeStamp > course[1]) timeStamp -= pq.poll();
        }

        return pq.size();
    }
}
