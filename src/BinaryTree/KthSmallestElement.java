package BinaryTree;

import ClassPackage.TreeNode;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Created by Lin on 2017/7/31.
 */
public class KthSmallestElement {
    /**
     * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @param k An integer.
     * @return The kth smallest element in BST.
     */
    public int kthSmallest(TreeNode root, int k) {

        int res = 0;
        TreeNode p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(k > 0){
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                k--;
                res = node.val;
                p = node.right;
            }
        }

        return res;
    }
}
