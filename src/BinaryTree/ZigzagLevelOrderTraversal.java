package BinaryTree;

import ClassPackage.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class ZigzagLevelOrderTraversal {

    /***************************************** Recursive Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return List of Integer in zigzag level order
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // create an empty list as result
        List<List<Integer>> res = new ArrayList<>();
        // create a list to store TreeNode in a level
        List<TreeNode> preLevelNodes = Arrays.asList(root);

        // invoke helper method to do recursion
        if(root != null) helper(res, preLevelNodes, true);

        // return result
        return res;
    }

    private void helper(List<List<Integer>> res, List<TreeNode> preLevelNodes, boolean toRight){
        // terminate case
        if(preLevelNodes.isEmpty()) return;

        // create list to store value in pre level
        List<Integer> preLevelVal = new ArrayList<>();
        // create list to store nodes in next level
        List<TreeNode> nextLevelNodes = new ArrayList<>();

        // store node in next level from left to right
        for(TreeNode node : preLevelNodes){
            if(node.left != null) nextLevelNodes.add(node.left);
            if(node.right != null) nextLevelNodes.add(node.right);
        }

        // store value based on direction
        if(toRight){
            for(int i = 0; i < preLevelNodes.size(); i++) preLevelVal.add(preLevelNodes.get(i).val);
        }
        else{
            for(int i = preLevelNodes.size() - 1; i >= 0; i--) preLevelVal.add(preLevelNodes.get(i).val);
        }

        // add data in current level into result
        if(!preLevelVal.isEmpty()) res.add(preLevelVal);

        // call next recursion
        helper(res, nextLevelNodes, !toRight);
    }

    /***************************************** Iterative Version *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return List of Integer in zigzag level order
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        // corner case
        if(root == null) return new ArrayList<>();

        // create an empty list as result
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));
        // create a list to store TreeNode in a level
        List<TreeNode> preLevelNodes = Arrays.asList(root);
        // a flag to determine direction
        boolean toRight = false;

        // do the loop until the last level
        while(!preLevelNodes.isEmpty()){
            // create lists to store data in next level
            List<Integer> nextLevelVal = new ArrayList<>();
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            // store node in next level from left to right
            for(TreeNode node : preLevelNodes){
                if(node.left != null) nextLevelNodes.add(node.left);
                if(node.right != null) nextLevelNodes.add(node.right);
            }
            // store value based on direction
            if(toRight){
                for(int i = 0; i < nextLevelNodes.size(); i++) nextLevelVal.add(nextLevelNodes.get(i).val);
            }
            else{
                for(int i =  nextLevelNodes.size() - 1; i >= 0; i--) nextLevelVal.add(nextLevelNodes.get(i).val);
            }
            // add data in current level into result
            if(!nextLevelVal.isEmpty()) res.add(nextLevelVal);
            // replace preLevel by current visited level
            preLevelNodes = nextLevelNodes;
            // change direction
            toRight = !toRight;
        }

        // return result
        return res;
    }
}
