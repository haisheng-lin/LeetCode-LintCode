package ClassPackage;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x){
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
