package BinaryTree;

import ClassPackage.TreeNode;
import java.util.Stack;

/**
 * Created by Lin on 2017/2/12.
 */
public class SymmetricTree {

    /***************************************** Recursion Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/symmetric-tree/">LeetCode</a>
     *
     * @param root Root of TreeNode
     * @return True if tree is symmetric, else false
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == right;
        return (left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left));
    }

    /***************************************** Iterative Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/symmetric-tree/">LeetCode</a>
     *
     * @param root Root of TreeNode
     * @return True if tree is symmetric, else false
     */
    public boolean isSymmetric2(TreeNode root) {
        // corner case
        if(root == null) return true;
        // create stacks for left subtree and right subtree
        Stack<TreeNode> lStack = new Stack<>(), rStack = new Stack<>();
        lStack.push(root.left);
        rStack.push(root.right);
        while(!lStack.isEmpty() || !rStack.isEmpty()){
            TreeNode lChild = lStack.pop(), rChild = rStack.pop();
            // check current node
            if((lChild == null || rChild == null) && lChild != rChild) return false;
            if(lChild == null && rChild == null) continue;
            if(lChild.val != rChild.val) return false;
            // push left.left and right.right
            lStack.push(lChild.left);
            rStack.push(rChild.right);
            // push left.right and right.left
            lStack.push(lChild.right);
            rStack.push(rChild.left);
        }
        // return true if passing the loop
        return true;
    }
}
