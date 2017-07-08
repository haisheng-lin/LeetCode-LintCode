package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/2/13.
 */
public class SortedArrayToBST {

    /**
     * Here is an example for understanding the problem.
     * Given a sorted array: [1, 2, 3, 4, 5, 6, 7], we can convert it to the height balanced BST as follows:
     *
     *                       4
     *                   /      \
     *                  2        6
     *                /  \     /  \
     *               1   3    5    7
     *
     * Obviously, root of BST should be the middle point in the array.
     * Left subtree should be the part of array which is in LHS of middle point
     * Right subtree should the part of the array which is in RHS of the middle point
     *
     * So we can partition the array to build left and right subtree
     * Repeat the steps until start point is greater than end point
     */

    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * @see <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">LeetCode</a>
     *
     * @param nums A sorted array
     * @return Root the binary search tree from the array
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end){
        // 1. 终止条件
        if(start > end) return null;

        // mid = (start + end) / 2, 这样为了防止溢出
        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        // 2. 母函数与子函数的关系
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);

        return root;
    }
}
