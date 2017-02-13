package Graph;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by Lin on 2017/2/12.
 */
public class CourseSchedule {
    /**
     * @see <a href="https://leetcode.com/problems/course-schedule/">LeetCode</a>
     *
     * @param numCourses An Integer, total number of courses
     * @param prerequisites A 2D Integer array, each subarray is a relationship between two courses: first one is prerequisite of second one
     * @return True if all courses can be completed, else false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // initialization
        Map<Integer, Integer> inMap = new HashMap<>();
        Map<Integer, List<Integer>> outMap = new HashMap<>();
        // fill in data
        for(int i = 0; i < prerequisites.length; i++){
            int pre = prerequisites[i][0], depend = prerequisites[i][1];
            // in degree
            if(!inMap.containsKey(pre)) inMap.put(pre, 0);
            inMap.put(depend, inMap.getOrDefault(depend, 0) + 1);
            // out degree
            List<Integer> outList = new ArrayList<>();
            if(outMap.containsKey(pre)) outList = outMap.get(pre);
            outList.add(depend);
            outMap.put(pre, outList);
            if(!outMap.containsKey(depend)) outMap.put(depend, new ArrayList<Integer>());
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int key : inMap.keySet()){
            if(inMap.get(key) == 0) queue.offer(key);
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            List<Integer> outList = outMap.get(pre);
            for(int depend : outList){
                int inDegree = inMap.get(depend) - 1;
                if(inDegree == 0) queue.offer(depend);
                inMap.put(depend, inDegree);
            }
        }
        // check if any dependency still exists
        for(int key : inMap.keySet()){
            if(inMap.get(key) > 0) return false;
        }

        return true;
    }
}
