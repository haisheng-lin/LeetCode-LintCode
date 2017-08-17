package BinaryTree;

import java.util.List;
import java.util.ArrayList;
import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/7/4.
 */
public class UniqueBSTsII {
    /**
     * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
     *
     * @see <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/#/description">LeetCode</a>
     *
     * @param n An integer
     * @return List of valid BSTs
     */
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end){

        List<TreeNode> list = new ArrayList<>();

        for(int i = start; i <= end; i++){
            List<TreeNode> left = helper(start, i - 1), right = helper(i + 1, end);

            if(!left.isEmpty() && !right.isEmpty()){
                for(TreeNode leftRoot: left){
                    for(TreeNode rightRoot: right){
                        TreeNode root = new TreeNode(i);
                        root.left = leftRoot;
                        root.right = rightRoot;
                        list.add(root);
                    }
                }
            }

            else if(left.isEmpty() && !right.isEmpty()){
                for(TreeNode rightRoot: right){
                    TreeNode root = new TreeNode(i);
                    root.right = rightRoot;
                    list.add(root);
                }
            }

            else if(!left.isEmpty() && right.isEmpty()){
                for(TreeNode leftRoot: left){
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    list.add(root);
                }
            }

            else list.add(new TreeNode(i));
        }

        return list;
    }
}
