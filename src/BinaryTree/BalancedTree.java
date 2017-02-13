package BinaryTree;

import ClassPackage.TreeNode;
import java.util.Stack;

/**
 * Created by Lin on 2017/2/12.
 */
public class BalancedTree {

    /***************************************** Recursive Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = countDepth(root.left), right = countDepth(root.right);
        return (isBalanced(root.left) && isBalanced(root.right) && Math.abs(right - left) <= 1);
    }

    private int countDepth(TreeNode root){
        // corner case
        if(root == null) return 0;
        // next recursion
        return Math.max(countDepth(root.left), countDepth(root.right)) + 1;
    }
}
