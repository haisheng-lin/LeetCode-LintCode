package BinaryTree;

import ClassPackage.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Created by Lin on 2017/7/13.
 */
public class PostorderTraversal {

    /***************************************** Recursive Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return Preorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if(root == null) return;

        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    /***************************************** Iterative Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/#/description">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return Postorder traversal of its nodes' values
     */
    public List<Integer> postorderTraversal2(TreeNode root) {

        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }

        return result;
    }
}
