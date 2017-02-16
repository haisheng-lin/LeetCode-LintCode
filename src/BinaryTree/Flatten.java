package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/2/13.
 */
public class Flatten {
    /**
     * Given a binary tree, flatten it to a linked list in-place.
     *
     * @see <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return Root of flattened tree
     */
    public void flatten(TreeNode root){
        // corner case
        if(root == null) return;

        // do next recursion
        flatten(root.left);
        flatten(root.right);

        // flatten
        TreeNode left = root.left;
        root.left = null;

        if(left != null){
            TreeNode tail = left;
            while(tail.right != null) tail = tail.right;
            tail.right = root.right;
            root.right = left;
        }
    }
}
