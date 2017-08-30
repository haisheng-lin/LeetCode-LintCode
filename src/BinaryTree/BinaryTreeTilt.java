package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/8/29.
 */
public class BinaryTreeTilt {

    int sum = 0;

    /**
     * Given a binary tree, return the tilt of the whole tree
     * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values
     * Null node has tilt 0
     * The tilt of the whole tree is defined as the sum of all nodes' tilt
     *
     * @see <a href="https://leetcode.com/problems/binary-tree-tilt/">LeetCode</a>
     *
     * @param root The root of binary tree
     * @return Tilt of the whole tree
     */
    public int findTilt(TreeNode root) {
        getSubtreeSum(root);
        return sum;
    }

    private int getSubtreeSum(TreeNode root) {

        if(root == null) return 0;

        int left = getSubtreeSum(root.left);
        int right = getSubtreeSum(root.right);

        sum += Math.abs(left - right);

        return left + right + root.val;
    }
}
