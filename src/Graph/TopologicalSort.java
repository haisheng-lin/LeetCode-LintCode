package Graph;

import ClassPackage.DirectedGraphNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by Lin on 2017/2/12.
 */
public class TopologicalSort {
    /**
     * @see <a href="http://www.lintcode.com/en/problem/topological-sorting/">LeetCode</a>
     *
     * @param graph A list of Directed graph node
     * @return Any topological order for the given graph.
     */
    public List<DirectedGraphNode> topSort(List<DirectedGraphNode> graph){
        // initialization
        List<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> inMap = new HashMap<>();
        // fill in data
        for(DirectedGraphNode node : graph){
            // in degree
            if(!inMap.containsKey(node)) inMap.put(node, 0);
            for(DirectedGraphNode neighbor : node.neighbors){
                if(!inMap.containsKey(neighbor)) inMap.put(neighbor, 1);
                else inMap.put(neighbor, inMap.get(neighbor) + 1);
            }
        }
        // topological sort
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node : inMap.keySet()){
            if(inMap.get(node) == 0) queue.offer(node);
        }
        while(!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            res.add(node);
            for(DirectedGraphNode neighbor : node.neighbors){
                int inDegree = inMap.get(neighbor) - 1;
                if(inDegree == 0) queue.offer(neighbor);
                inMap.put(neighbor, inDegree);
            }
        }
        // return result
        return res;
    }
}
