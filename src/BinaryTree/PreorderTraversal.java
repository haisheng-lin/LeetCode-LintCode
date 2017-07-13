package BinaryTree;

import ClassPackage.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Lin on 2017/2/12.
 */
public class PreorderTraversal {

    /***************************************** Recursive Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if(root == null) return;

        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    /***************************************** Iterative Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal2(TreeNode root){

        List<Integer> res = new ArrayList<>();

        // stack is similar to memory stack in recursion
        Stack<TreeNode> stack = new Stack<>();

        // have a check here to handle corner case
        if(root != null) stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);

            // since stack has FILO property, so we push right child first
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }

        return res;
    }
}
