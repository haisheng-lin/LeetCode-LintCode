package BinaryTree;

import ClassPackage.TreeNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class BinaryTreePaths {

    // Define a global variable used in String construction.
    final String split = "->";

    /**
     * Path should look like this format: 1->2->3->4...
     * @see <a href="https://leetcode.com/problems/binary-tree-paths/">LeetCode</a>
     *
     * @param root A TreeNode
     * @return All paths from the root to the leaf node
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // create empty list as result
        List<String> res = new ArrayList<>();
        // recursion
        helper(root, res, new StringBuilder());
        // return result
        return res;
    }

    private void helper(TreeNode root, List<String> res, StringBuilder sb){
        // corner case
        if(root == null) return;

        if(sb.length() > 0) sb.append(split);
        sb.append(root.val);

        if(root.left == null && root.right == null) res.add(sb.toString());

        StringBuilder left = new StringBuilder(sb);
        helper(root.left, res, left);
        StringBuilder right = new StringBuilder(sb);
        helper(root.right, res, right);
    }
}
