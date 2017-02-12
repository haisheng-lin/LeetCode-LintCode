package ClassPackage;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class DirectedGraphNode {
    public int label;
    public List<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x; neighbors = new ArrayList<DirectedGraphNode>();
    }
}
