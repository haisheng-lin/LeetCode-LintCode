package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/8/1.
 */
public class LowestCommonAncestorOfBinaryTree {
    /**
     * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @param p A node in the tree.
     * @param q A node in the tree.
     * @return The lowest common ancestor (LCA) of two given nodes
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        if(p == root || q == root) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        else return (left != null) ? left : right;
    }
}
