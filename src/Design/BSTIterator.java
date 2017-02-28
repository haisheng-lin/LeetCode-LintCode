package Design;

import ClassPackage.TreeNode;
import java.util.Stack;

/**
 * Created by Lin on 2017/2/27.
 */
public class BSTIterator {
    /** @see <a href="https://leetcode.com/problems/binary-search-tree-iterator/?tab=Description">LeetCode</a> */

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        if(node.right != null){
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }

        return val;
    }
}
