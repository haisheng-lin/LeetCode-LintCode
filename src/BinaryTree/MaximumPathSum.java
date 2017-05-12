package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/2/28.
 */
public class MaximumPathSum {

    int max;

    /**
     * Given a binary tree, find the maximum path sum.
     * @see <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/?tab=Description">LeetCode</a>
     * @see <a href="https://discuss.leetcode.com/topic/4407/accepted-short-solution-in-java/2">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return An integer, maximum path sum
     */
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathDown(root);
        return max;
    }

    private int maxPathDown(TreeNode root){
        // terminate case
        if(root == null) return 0;

        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));

        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
