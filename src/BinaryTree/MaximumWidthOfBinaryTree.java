package BinaryTree;

import ClassPackage.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 2017/8/21.
 */
public class MaximumWidthOfBinaryTree {
    /**
     * Given a binary tree, write a function to get the maximum width of the given tree
     * The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null
     *
     * @see <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/">LeetCode</a>
     *
     * @param root The root of binary tree
     * @return Maximum width of the given tree
     */
    public int widthOfBinaryTree(TreeNode root) {

        // corner case
        if(root == null) return 0;

        int res = 1;

        List<TreeNode> preLevelNodes = new ArrayList<>();
        List<Integer> preLevelIndice = new ArrayList<>();
        preLevelNodes.add(root);
        preLevelIndice.add(0);

        while(!preLevelNodes.isEmpty()){

            List<TreeNode> curLevelNodes = new ArrayList<>();
            List<Integer> curLevelIndice = new ArrayList<>();

            for(int i = 0; i < preLevelNodes.size(); i++) {
                TreeNode node = preLevelNodes.get(i);
                if(node.left != null) {
                    curLevelNodes.add(node.left);
                    curLevelIndice.add(2 * preLevelIndice.get(i));
                }
                if(node.right != null) {
                    curLevelNodes.add(node.right);
                    curLevelIndice.add(2 * preLevelIndice.get(i) + 1);
                }
            }

            if(!curLevelIndice.isEmpty()) res = Math.max(res, curLevelIndice.get(curLevelIndice.size() - 1) - curLevelIndice.get(0) + 1);

            preLevelNodes = curLevelNodes;
            preLevelIndice = curLevelIndice;
        }

        return res;
    }
}
