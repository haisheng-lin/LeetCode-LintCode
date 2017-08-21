package BinaryTree;

import ClassPackage.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Lin on 2017/8/21.
 */
public class FindBottomLeftTreeValue {

    /***************************************** My Solution *****************************************/

    int maxLevel = 0;

    /**
     * @see <a href="https://leetcode.com/problems/find-bottom-left-tree-value/">LeetCode</a>
     *
     * @param root The root of binary tree
     * @return The leftmost value in the last row of the tree
     */
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, TreeNode> map = new HashMap<>();
        helper(root, map, 0);

        return map.get(maxLevel).val;
    }

    private void helper(TreeNode root, Map<Integer, TreeNode> map, int level) {
        if(root == null) return;

        if(!map.containsKey(level)){
            map.put(level, root);
            maxLevel = Math.max(maxLevel, level);
        }

        helper(root.left, map, level + 1);
        helper(root.right, map, level + 1);
    }

    /***************************************** Best Solution *****************************************/

    /**
     * @see <a href="https://leetcode.com/problems/find-bottom-left-tree-value/">LeetCode</a>
     *
     * @param root The root of binary tree
     * @return The leftmost value in the last row of the tree
     */
    public int findBottomLeftValue2(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }

        return root.val;
    }
}
