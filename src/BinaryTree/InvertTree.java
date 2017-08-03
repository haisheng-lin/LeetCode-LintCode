package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/7/30.
 */
public class InvertTree {
    /**
     * Invert a binary tree.
     *
     * @see <a href="https://leetcode.com/problems/invert-binary-tree/">LeetCode</a>
     *
     * @param root The root of the binary tree.
     * @return The root of the inverted binary tree.
     */
    public TreeNode invertTree(TreeNode root) {

        // corner case
        if(root == null) return null;

        // swap
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;

        return root;
    }
}
