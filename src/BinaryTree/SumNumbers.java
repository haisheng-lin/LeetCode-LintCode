package BinaryTree;

import ClassPackage.TreeNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class SumNumbers {

    /***************************************** Recursive Version *****************************************/

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     *
     * @see <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">LeetCode</a>
     *
     * @param root Root of TreeNode
     * @return Total sum of numbers
     */
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int curSum){

        if(root == null) return curSum;

        curSum = 10 * curSum + root.val;

        if(root.left == null && root.right == null) return curSum;

        int left = root.left == null ? 0 : helper(root.left, curSum);
        int right = root.right == null ? 0 : helper(root.right, curSum);

        return left + right;
    }

    /***************************************** Iterative Version *****************************************/

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     *
     * @see <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">LeetCode</a>
     *
     * @param root Root of TreeNode
     * @return Total sum of numbers
     */
    public int sumNumbers2(TreeNode root) {

        int res = 0;
        List<Integer> preLevelVal = new ArrayList<>();
        List<TreeNode> preLevelNodes = new ArrayList<>();
        if(root != null){
            preLevelVal.add(root.val);
            preLevelNodes.add(root);
        }

        while(!preLevelNodes.isEmpty()){
            List<Integer> curLevelVal = new ArrayList<>();
            List<TreeNode> curLevelNodes = new ArrayList<>();

            for(int i = 0; i < preLevelNodes.size(); i++){
                TreeNode node = preLevelNodes.get(i);
                if(node.left == null && node.right == null){
                    res += preLevelVal.get(i);
                }
                if(node.left != null){
                    curLevelVal.add(10 * preLevelVal.get(i) + node.left.val);
                    curLevelNodes.add(node.left);
                }
                if(node.right != null){
                    curLevelVal.add(10 * preLevelVal.get(i) + node.right.val);
                    curLevelNodes.add(node.right);
                }
            }

            preLevelVal = curLevelVal;
            preLevelNodes = curLevelNodes;
        }

        return res;
    }
}
