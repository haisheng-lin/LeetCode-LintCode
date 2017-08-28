package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/8/26.
 */
public class AddOneRowToTree {
    /**
     * @see <a href="https://leetcode.com/problems/add-one-row-to-tree/">LeetCode</a>
     *
     * @param root The root of binary tree
     * @param v Integer
     * @param d Integer
     * @return Root of new binary tree
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        return dfs(root, v, d, 1);
    }

    private TreeNode dfs(TreeNode root, int v, int d, int curLevel) {

        if(root == null) return root;

        if(curLevel == d - 1) {
            TreeNode left = new TreeNode(v), right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        } else {
            dfs(root.left, v, d, curLevel + 1);
            dfs(root.right, v, d, curLevel + 1);
        }

        return root;
    }
}
