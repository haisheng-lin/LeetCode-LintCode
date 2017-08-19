package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/8/18.
 */
public class ConvertBSTToGreaterTree {

    int sum = 0;

    /**
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
     *
     * @see <a href="https://leetcode.com/problems/construct-string-from-binary-tree/">LeetCode</a>
     *
     * @param root The root of BST
     * @return String of the binary tree
     */
    public TreeNode convertBST(TreeNode root) {

        if(root == null) return null;

        TreeNode right = convertBST(root.right);

        TreeNode res = new TreeNode(root.val + sum);
        sum += root.val;

        TreeNode left = convertBST(root.left);

        res.left = left;
        res.right = right;

        return res;
    }
}
