package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class ValidateBST {
    /**
     * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">LeetCode</a>
     *
     * @param root The root of binary tree
     * @return True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        long min = (long)Integer.MIN_VALUE - 1;
        long max = (long)Integer.MAX_VALUE + 1;

        return helper(root, min, max);
    }

    private boolean helper(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
