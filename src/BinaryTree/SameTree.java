package BinaryTree;

import ClassPackage.TreeNode;
import java.util.Stack;

/**
 * Created by Lin on 2017/2/12.
 */
public class SameTree {

    /***************************************** Recursion Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/same-tree/">LeetCode</a>
     *
     * @param p Root of TreeNode
     * @param q Root of TreeNode
     * @return True if two trees are the same, else false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;
        return (p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }

    /***************************************** Iterative Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/same-tree/">LeetCode</a>
     *
     * @param p Root of TreeNode
     * @param q Root of TreeNode
     * @return True if two trees are the same, else false
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        // create stacks to store tree nodes
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.push(p);
        qStack.push(q);
        while(!pStack.isEmpty() || !qStack.isEmpty()){
            TreeNode pNode = pStack.pop(), qNode = qStack.pop();
            // check current node
            if((pNode == null || qNode == null) && pNode != qNode) return false;
            if(pNode == null && qNode == null) continue;
            if(pNode.val != qNode.val) return false;
            // push right child next check
            pStack.push(pNode.right);
            qStack.push(qNode.right);
            // push left child for next check
            pStack.push(pNode.left);
            qStack.push(qNode.left);
        }
        // return true if passing loop check
        return true;
    }
}
