package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class MaxDepth {
    /**
     * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return An integer.
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
