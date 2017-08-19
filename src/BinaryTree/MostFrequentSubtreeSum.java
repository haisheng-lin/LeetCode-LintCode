package BinaryTree;

import ClassPackage.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lin on 2017/8/19.
 */
public class MostFrequentSubtreeSum {
    /**
     * Given the root of a tree, you are asked to find the most frequent subtree sum.
     *
     * @see <a href="https://leetcode.com/problems/most-frequent-subtree-sum/">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return Most frequent subtree sum
     */
    public int[] findFrequentTreeSum(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> frequency = new HashMap<>();
        subtreeSum(root, frequency);
        int max = 0;

        for(int sum: frequency.keySet()){
            max = Math.max(max, frequency.get(sum));
        }

        for(int sum: frequency.keySet()){
            if(frequency.get(sum) == max) list.add(sum);
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);

        return res;
    }

    private int subtreeSum(TreeNode root, Map<Integer, Integer> frequency) {

        if(root == null) return 0;

        int sum = root.val + subtreeSum(root.left, frequency) + subtreeSum(root.right, frequency);
        frequency.put(sum, frequency.getOrDefault(sum, 0) + 1);

        return sum;
    }
}
