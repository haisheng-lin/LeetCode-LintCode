package BinaryTree;

import ClassPackage.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Lin on 2017/7/4.
 */
public class InorderTraversal {

/***************************************** Recursive Version *****************************************/

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/#/description">LeetCode</a>
 *
 * @param root The root of binary tree.
 * @return Inorder in ArrayList which contains node values.
 */
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(res, root);

    return res;
}

private void helper(List<Integer> res, TreeNode root){
    // corner case
    if(root == null) return;

    helper(res, root.left);
    res.add(root.val);
    helper(res, root.right);
}

/***************************************** Iterative Version *****************************************/

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/#/description">LeetCode</a>
 * 参考：<a href="https://discuss.leetcode.com/topic/6478/iterative-solution-in-java-simple-and-readable">LeetCode</a>
 *
 * @param root The root of binary tree.
 * @return Inorder in ArrayList which contains node values.
 */
public List<Integer> inorderTraversal2(TreeNode root){

    List<Integer> res = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;

    while(cur != null || !stack.empty()){
        while(cur != null){
            stack.add(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        res.add(cur.val);
        cur = cur.right;
    }

    return res;
}
}
