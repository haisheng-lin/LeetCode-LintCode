package BinaryTree;

import ClassPackage.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lin on 2017/8/24.
 */
public class FindDuplicateSubtrees {
    /**
     * Given a binary tree, return all duplicate subtrees
     * For each kind of duplicate subtrees, you only need to return the root node of any one of them
     *
     * @see <a href="https://leetcode.com/problems/find-duplicate-subtrees/">LeetCode</a>
     *
     * @param root The root of binary tree
     * @return All duplicate subtrees
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        serialization(root, res, map);

        return res;
    }

    private String serialization(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {

        if(root == null) return "#";

        String serial = root.val + "," + serialization(root.left, res, map) + "," + serialization(root.right, res, map);

        if(map.getOrDefault(serial, 0) == 1) res.add(root);
        map.put(serial, map.getOrDefault(serial, 0) + 1);

        return serial;
    }
}
