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

        // Step 1: 初始化入度和出度哈希表
        Map<Integer, Integer> inMap = new HashMap<>();
        Map<Integer, List<Integer>> outMap = new HashMap<>();

        // Step 2: 遍历数组，获取所有课程入度和出度数据
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
            if(!outMap.containsKey(depend)) outMap.put(depend, new ArrayList<>());
        }

        // Step 3: 对所有没有前提的课程，更新对应的出度课程表的入度值
        Queue<Integer> queue = new LinkedList<>();
        for(int pre : inMap.keySet()){
            if(inMap.get(pre) == 0) queue.offer(pre);
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

        // Step 4: 检查课程是否依然存在依赖关系
        for(int key : inMap.keySet()){
            if(inMap.get(key) > 0) return false;
        }

        return true;
    }
}
