package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class InsertNode {
    /**
     * @see <a href="http://www.lintcode.com/en/problem/insert-node-in-a-binary-search-tree/">LeetCode</a>
     *
     * @param root The root of the binary search tree.
     * @param node Node to be inserted into the tree
     * @return The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root == null) return node;
        if(root.val < node.val) return insertNode(root.right, node);
        else if(root.val > node.val) return insertNode(node.left, node);

        return root;
    }
}
