package BinaryTree;

import ClassPackage.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lin on 2017/8/21.
 */
public class EqualTreePartition {
    /**
     * Given a binary tree with n nodes, check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.
     *
     * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">LeetCode</a>
     *
     * @param root The root of binary tree
     * @return True if the tree can be partitioned into two subtrees whose sum is equal
     */
    public boolean checkEqualTree(TreeNode root) {

        Map<TreeNode, Integer> map = new HashMap<>();
        getSum(root, map);

        int total = map.get(root);
        map.remove(root);

        for(TreeNode node: map.keySet()) {
            if(map.get(node) * 2 == total) return true;
        }

        return false;
    }

    private int getSum(TreeNode root, Map<TreeNode, Integer> map) {

        if(root == null) return 0;

        int left = getSum(root.left, map), right = getSum(root.right, map);
        int sum = root.val + left + right;
        map.put(root, sum);

        return sum;
    }
}
