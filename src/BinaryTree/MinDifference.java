package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/2/27.
 */
public class MinDifference {

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    /**
     * Find the minimum absolute difference between values of any two nodes.
     * @see <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/?tab=Description">LeetCode</a>
     *
     * @param root Root of the tree
     * @return Integer, min absolute difference
     */
    public int getMinimumDifference(TreeNode root) {
        // corner case
        if(root == null) return min;

        getMinimumDifference(root.left);

        if(prev != null) min = Math.min(min, Math.abs(root.val - prev));
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }
}
