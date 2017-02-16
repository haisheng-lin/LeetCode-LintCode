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
        // create a list to store paths as result
        List<List<Integer>> res = new ArrayList<>();
        // create a list to store current path, LinkedList is faster than ArrayList in respect of deletion
        if(root != null) helper(res, new LinkedList<>(), root, sum);
        // return result
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum){
        // current node is a leaf, then should return
        if(root.left == null && root.right == null){
            if(root.val == sum){
                list.add(root.val);
                // usually return ArrayList
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }

        list.add(root.val);

        // invoke next recursion
        if(root.left != null) helper(res, list, root.left, sum - root.val);
        if(root.right != null) helper(res, list, root.right, sum - root.val);

        list.remove(list.size() - 1);
    }
}
