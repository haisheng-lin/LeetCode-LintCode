package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/7/7.
 */
public class MinimumDepthOfBinaryTree {
    /**
     * Given a binary tree, find its minimum depth
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node
     *
     * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/#/description">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return minimum depth.
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.right != null) return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

        return (root.left == null) ? (minDepth(root.right) + 1) : (minDepth(root.left) + 1);
    }
}
