package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/8/1.
 */
public class LowestCommonAncestorOfBST {
    /**
     * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree">LeetCode</a>
     *
     * @param root The root of binary search tree.
     * @param p A node in the tree.
     * @param q A node in the tree.
     * @return The lowest common ancestor (LCA) of two given nodes
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
