package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/8/18.
 */
public class MergeTwoBinaryTrees {
    /**
     * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
     * Merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
     * Otherwise, the NOT null node will be used as the node of new tree.
     *
     * @see <a href="https://leetcode.com/problems/merge-two-binary-trees/">LeetCode</a>
     *
     * @param t1 Root of binary tree
     * @param t2 Root of binary tree
     * @return Root of merged binary tree
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1 == null && t2 == null) return null;

        TreeNode root;

        if(t1 != null && t2 != null) {
            root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }

        else if(t1 != null && t2 == null) {
            root = new TreeNode(t1.val);
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
        }

        else {
            root = new TreeNode(t2.val);
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
        }

        return root;
    }
}
