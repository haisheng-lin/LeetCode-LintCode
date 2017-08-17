package BinaryTree;

import ClassPackage.TreeNode;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/7/6.
 */
public class LevelOrderTraversalII {
    /**
     * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return List of Integer in level order
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> preLevel = new ArrayList<>();
        List<TreeNode> preNodes = new ArrayList<>();
        if(root != null){
            preLevel.add(root.val);
            preNodes.add(root);
        }

        while(!preNodes.isEmpty()){
            res.add(preLevel);

            List<Integer> nextLevel = new ArrayList<>();
            List<TreeNode> nextNodes = new ArrayList<>();

            for(TreeNode node: preNodes){
                if(node.left != null){
                    nextLevel.add(node.left.val);
                    nextNodes.add(node.left);
                }
                if(node.right != null){
                    nextLevel.add(node.right.val);
                    nextNodes.add(node.right);
                }
            }

            preLevel = nextLevel;
            preNodes = nextNodes;
        }

        Collections.reverse(res);

        return res;
    }
}
