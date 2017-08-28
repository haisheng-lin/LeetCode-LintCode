package BinaryTree;

import ClassPackage.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Lin on 2017/8/27.
 */
public class AverageOfLevelsInBinaryTree {
    /**
     * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
     *
     * @see <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/">LeetCode</a>
     *
     * @param root The root of binary tree
     * @return Average value of the nodes on each level in the form of an array
     */
    public List<Double> averageOfLevels(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            int size = queue.size();
            double sum = 0;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            double avg = sum / size;
            res.add(avg);
        }

        return res;
    }
}
