package BinaryTree;

import ClassPackage.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 2017/8/21.
 */
public class FindLargestValueInEachTreeRow {
    /**
     * Find the largest value in each row of a binary tree
     *
     * @see <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return List of largest value in each row of the tree
     */
    public List<Integer> largestValues(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        List<TreeNode> preLevel = new ArrayList<>();
        preLevel.add(root);
        res.add(root.val);

        while(!preLevel.isEmpty()) {
            List<TreeNode> curLevel = new ArrayList<>();
            int max = Integer.MIN_VALUE;

            for(TreeNode node: preLevel){
                if(node.left != null){
                    curLevel.add(node.left);
                    max = Math.max(max, node.left.val);
                }
                if(node.right != null){
                    curLevel.add(node.right);
                    max = Math.max(max, node.right.val);
                }
            }

            if(!curLevel.isEmpty()) res.add(max);
            preLevel = curLevel;
        }

        return res;
    }
}
