package Graph;

import ClassPackage.UndirectedGraphNode;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/2/12.
 */
public class CloneGraph {

    /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     *     int label;
     *     List<UndirectedGraphNode> neighbors;
     *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     * };
     */

    // create a map to store which node is copied
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    /**
     * @see <a href="https://leetcode.com/problems/clone-graph/">LeetCode</a>
     *
     * @param node An UndirectedGraphNode
     * @return An cloned UndirectedGraphNode
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // corner case
        if(node == null) return null;

        UndirectedGraphNode res = new UndirectedGraphNode(node.label);

        // add into map, which means the node is already copied
        map.put(node, res);

        for(UndirectedGraphNode neighbor : node.neighbors){
            // if the neighbor is copied, no need to do recursion
            if(map.containsKey(neighbor)) res.neighbors.add(map.get(neighbor));
            else res.neighbors.add(cloneGraph(neighbor));
        }

        return res;
    }
}
