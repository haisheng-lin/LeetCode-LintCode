package Array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Lin on 2017/8/27.
 */
public class TaskScheduler {
    /**
     * Given a char array representing tasks CPU need to do
     * It contains capital letters A to Z where different letters represent different tasks
     * Tasks could be done without original order. Each task could be done in one interval
     * For each interval, CPU could finish one task or just be idle
     * However between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle
     * Return the least number of intervals the CPU will take to finish all the given tasks
     *
     * @see <a href="https://leetcode.com/problems/task-scheduler/">LeetCode</a>
     *
     * @param tasks Char array
     * @param n Integer
     * @return Least number of intervals the CPU will take to finish all the given tasks
     */
    public int leastInterval(char[] tasks, int n) {

        int res = 0;

        int timeStamp = 0;

        // count number of each task
        int[] nums = new int[26];
        for(char c: tasks) nums[c - 'A']++;

        Queue<Task> pq = new PriorityQueue<>(new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.startTime == o2.startTime) return o2.nums - o1.nums;
                else return o1.startTime - o2.startTime;
            }
        });

        for(int num: nums) {
            if(num > 0) pq.offer(new Task(num, 0));
        }

        while(!pq.isEmpty()) {

            Task task = pq.poll();

            if(task.startTime > timeStamp) {
                res += task.startTime - timeStamp;
                timeStamp = task.startTime;
                pq.offer(task);
            } else {
                task.nums--;
                task.startTime += n + 1;
                timeStamp++;
                res++;

                if(task.nums > 0) pq.offer(task);
            }

        }

        return res;
    }

    class Task {
        int nums;
        int startTime;

        public Task(int n, int t) {
            this.nums = n;
            this.startTime = t;
        }
    }
}
