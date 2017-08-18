package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/8/18.
 */
public class ConstructStringFromBinaryTree {
    /**
     * Construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way
     * The null node needs to be represented by empty parenthesis pair "()"
     * Omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree
     *
     * @see <a href="https://leetcode.com/problems/construct-string-from-binary-tree/">LeetCode</a>
     *
     * @param t The root of binary tree
     * @return String of the binary tree
     */
    public String tree2str(TreeNode t) {
        return helper(t, new StringBuilder()).toString();
    }

    private StringBuilder helper(TreeNode t, StringBuilder sb) {

        if(t == null) return sb;

        sb.append(t.val);

        if(t.left != null) {
            sb.append('(');
            helper(t.left, sb);
            sb.append(')');
        }

        if(t.right != null) {
            if(t.left == null) sb.append("()");
            sb.append('(');
            helper(t.right, sb);
            sb.append(')');
        }


        return sb;
    }
}
