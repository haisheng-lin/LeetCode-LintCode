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
            TreeNode p = stack.pop();
            res.add(p.val);
            // since stack has FILO property, so we push right child first
            if(p.right != null) stack.push(p.right);
            if(p.left != null) stack.push(p.left);
        }

        return res;
    }
}
