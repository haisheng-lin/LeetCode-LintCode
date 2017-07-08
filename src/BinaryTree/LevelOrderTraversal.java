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

        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));

        List<TreeNode> preLevelNodes = Arrays.asList(root);

        helper(res, preLevelNodes);

        return res;
    }

    private void helper(List<List<Integer>> res, List<TreeNode> preLevelNodes){
        // terminate case
        if(preLevelNodes.isEmpty()) return;

        List<Integer> nextLevelVal = new ArrayList<>();
        List<TreeNode> nextLevelNodes = new ArrayList<>();

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
        if(!nextLevelVal.isEmpty()) res.add(nextLevelVal);

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

        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));

        List<TreeNode> preLevelNodes = Arrays.asList(root);

        while(!preLevelNodes.isEmpty()){

            List<Integer> nextLevelVal = new ArrayList<>();
            List<TreeNode> nextLevelNodes = new ArrayList<>();

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

            if(!nextLevelVal.isEmpty()) res.add(nextLevelVal);

            preLevelNodes = nextLevelNodes;
        }

        return res;
    }
}
