package BinaryTree;

import ClassPackage.TreeNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/24.
 */
public class RightSideView {
    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return The values of the nodes you can see ordered from top to bottom, standing on the right side of the tree
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);

        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int depth){
        // terminate case
        if(root == null) return;

        if(res.size() == depth) res.add(root.val);

        helper(res, root.right, depth + 1);
        helper(res, root.left, depth + 1);
    }
}
