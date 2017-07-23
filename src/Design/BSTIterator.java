package Design;

import ClassPackage.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Created by Lin on 2017/2/27.
 */
public class BSTIterator {

    /** @see <a href="https://leetcode.com/problems/binary-search-tree-iterator/?tab=Description">LeetCode</a> */

    Deque<TreeNode> stack;
    TreeNode node;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        node = root;
        helper();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = stack.pop();
        if(next.right != null){
            node = next.right;
            helper();
        }

        return next.val;
    }

    private void helper(){

        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}
