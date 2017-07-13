package BinaryTree;

import ClassPackage.TreeNode;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Lin on 2017/7/13.
 */
public class BinaryTreeTraversalSummarization {

    /***************************************** Preorder Traversal *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/#/description">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return Preorder traversal of its nodes' values
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }

        return result;
    }

    /***************************************** Inorder Traversal *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/#/description">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return Inorder traversal of its nodes' values
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(p.val);
                p = node.right;
            }
        }

        return result;
    }

    /***************************************** Postorder Traversal *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/#/description">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return Postorder traversal of its nodes' values
     */
    public List<Integer> postorderTraversal(TreeNode root) {

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
