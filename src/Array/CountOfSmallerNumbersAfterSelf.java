package Array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lin on 2017/8/23.
 */
public class CountOfSmallerNumbersAfterSelf {

    class TreeNode {
        TreeNode left, right;
        int val, sum;
        int dup = 1;
        public TreeNode(int v, int s) {
            this.val = v;
            this.sum = s;
        }
    }

    /**
     * You are given an integer array nums and you have to return a new counts array
     * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i]
     *
     * @see <a href="https://leetcode.com/problems/count-of-smaller-numbers-after-self/">LeetCode</a>
     *
     * @param nums An Integer array
     * @return Array where counts[i] is the number of smaller elements to the right of nums[i]
     */
    public List<Integer> countSmaller(int[] nums) {

        Integer[] res = new Integer[nums.length];
        TreeNode root = null;

        for(int i = nums.length - 1; i >= 0; i--) {
            insert(res, nums[i], i, root, 0);
        }

        return Arrays.asList(res);
    }

    private TreeNode insert(Integer[] res, int num, int i, TreeNode node, int preSum) {

        if(node == null) {
            node = new TreeNode(num, 0);
            res[i] = preSum;
        } else if(node.val == num) {
            node.dup++;
            res[i] = preSum + node.sum;
        } else if(node.val < num) {
            node.right = insert(res, num, i, node.right, preSum + node.dup + node.sum);
        } else {
            node.sum++;
            node.left = insert(res, num, i, node.left, preSum);
        }

        return node;
    }
}
