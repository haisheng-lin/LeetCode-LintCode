package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class SumNumbers {
    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     *
     * @see <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">LeetCode</a>
     *
     * @param root Root of TreeNode
     * @return Total sum of numbers
     */
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int curSum){
        // case 1
        if(root == null) return curSum;
        curSum = 10 * curSum + root.val;
        // case 2
        if(root.left == null && root.right == null) return curSum;
        // case 3
        int left = root.left == null ? 0 : helper(root.left, curSum);
        int right = root.right == null ? 0 : helper(root.right, curSum);
        return left + right;
    }
}
