package BinaryTree;

import ClassPackage.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/13.
 */
public class PathSum {

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
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     * This method is DFS algorithm
     *
     * @see <a href="https://leetcode.com/problems/path-sum/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @param sum An Integer target
     * @return True if there is at least one path sum equals to target, else false.
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // corner case
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /***************************************** Iterative Version *****************************************/

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     * This method is BFS algorithm
     *
     * @see <a href="https://leetcode.com/problems/path-sum/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @param sum An Integer target
     * @return True if there is at least one path sum equals to target, else false.
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        // corner case
        if(root == null) return false;

        List<TreeNode> preLevelNodes = Arrays.asList(root);
        List<Integer> preLevelSums = Arrays.asList(root.val);

        // loop until there is no node in the level
        while(!preLevelNodes.isEmpty()){
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            List<Integer> nextLevelSums = new ArrayList<>();

            for(int i = 0; i < preLevelNodes.size(); i++){
                TreeNode node = preLevelNodes.get(i);

                // if the current node is a leaf (no child)
                if(node.left == null && node.right == null){
                    // if the path sum equals to target, return true
                    if(preLevelSums.get(i) == sum) return true;
                }

                // store current sum in next level
                if(node.left != null){
                    nextLevelNodes.add(node.left);
                    nextLevelSums.add(preLevelSums.get(i) + node.left.val);
                }
                if(node.right != null){
                    nextLevelNodes.add(node.right);
                    nextLevelSums.add(preLevelSums.get(i) + node.right.val);
                }
            }

            preLevelNodes = nextLevelNodes;
            preLevelSums = nextLevelSums;
        }

        return false;
    }
}
