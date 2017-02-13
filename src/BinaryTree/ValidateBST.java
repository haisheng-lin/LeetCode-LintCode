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
        long upBound = (long) Integer.MAX_VALUE + 1;
        long lowBound = (long) Integer.MIN_VALUE - 1;

        return helper(root, lowBound, upBound);
    }

    private boolean helper(TreeNode root, long lowBound, long upBound){
        if(root == null) return true;
        if(lowBound >= root.val || root.val >= upBound) return false;
        return helper(root.left, lowBound, root.val) && helper(root.right, root.val, upBound);
    }
}
