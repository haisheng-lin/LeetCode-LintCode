package BinaryTree;

import ClassPackage.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/13.
 */
public class PathSum2 {

    /**
     * Here is an example for understanding the problem. Given a tree as follows:
     *
     *                       4
     *                   /      \
     *                  2        6
     *                /  \     /  \
     *               1   3    5    7
     *              / \   \       /
     *             0  3   6      2
     *
     * Given target sum is 15, the tree has a path: 4 -> 6 -> 5, which sums to 15.
     * Another path is 4 -> 2 -> 3 -> 6.
     */

    /***************************************** Recursive Version *****************************************/

    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     *
     * @see <a href="https://leetcode.com/problems/path-sum-ii/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @param sum An Integer target
     * @return List of path in the tree which sums to target
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) helper(res, new ArrayList<>(), root, sum);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum){

        path.add(root.val);

        if(root.left == null && root.right == null && root.val == sum) res.add(new ArrayList<>(path));

        if(root.left != null) helper(res, path, root.left, sum - root.val);
        if(root.right != null) helper(res, path, root.right, sum - root.val);

        path.remove(path.size() - 1);
    }
}
