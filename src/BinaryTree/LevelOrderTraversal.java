package BinaryTree;

import ClassPackage.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class LevelOrderTraversal {

    /***************************************** Recursive Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return List of Integer in level order
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // corner case
        if(root == null) return new ArrayList<>();

        // create an empty list as result
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));
        // create a list to store TreeNode in a level
        List<TreeNode> preLevelNodes = Arrays.asList(root);

        // invoke helper method to do recursion
        helper(res, preLevelNodes);

        // return result
        return res;
    }

    private void helper(List<List<Integer>> res, List<TreeNode> preLevelNodes){
        // terminate case
        if(preLevelNodes.isEmpty()) return;

        // create lists to store data in next level
        List<Integer> nextLevelVal = new ArrayList<>();
        List<TreeNode> nextLevelNodes = new ArrayList<>();

        // loop each node from pre level
        for(TreeNode node : preLevelNodes){
            if(node.left != null){
                nextLevelVal.add(node.left.val);
                nextLevelNodes.add(node.left);
            }
            if(node.right != null){
                nextLevelVal.add(node.right.val);
                nextLevelNodes.add(node.right);
            }
        }
        // add data in current level into result
        if(!nextLevelVal.isEmpty()) res.add(nextLevelVal);

        // call next recursion
        helper(res, nextLevelNodes);
    }

    /***************************************** Iterative Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return List of Integer in level order
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        // corner case
        if(root == null) return new ArrayList<>();

        // create an empty list as result
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));
        // create a list to store TreeNode in a level
        List<TreeNode> preLevelNodes = Arrays.asList(root);

        // do the loop until the last level
        while(!preLevelNodes.isEmpty()){
            // create lists to store data in next level
            List<Integer> nextLevelVal = new ArrayList<>();
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            // loop each node from pre level
            for(TreeNode node : preLevelNodes){
                if(node.left != null){
                    nextLevelVal.add(node.left.val);
                    nextLevelNodes.add(node.left);
                }
                if(node.right != null){
                    nextLevelVal.add(node.right.val);
                    nextLevelNodes.add(node.right);
                }
            }
            // add data in current level into result
            if(!nextLevelVal.isEmpty()) res.add(nextLevelVal);
            // replace preLevel by current visited level
            preLevelNodes = nextLevelNodes;
        }

        // return result
        return res;
    }
}
