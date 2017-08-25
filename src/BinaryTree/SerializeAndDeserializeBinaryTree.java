package BinaryTree;

import ClassPackage.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lin on 2017/8/25.
 */
public class SerializeAndDeserializeBinaryTree {

    /**
     * Design an algorithm to serialize and deserialize a binary tree
     * There is no restriction on how your serialization/deserialization algorithm should work
     * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure
     *
     * @see <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">LeetCode</a>
     */

    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializeHelper(root);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root) {

        if(root == null){
            sb.append('#');
            return;
        }

        sb.append(root.val);
        sb.append(',');
        serializeHelper(root.left);
        sb.append(',');
        serializeHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] nodes = sb.toString().split(",");
        Queue<String> queue = new LinkedList<>();

        for(String node: nodes) {
            queue.offer(node);
        }

        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {

        String str = queue.poll();
        if(str.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.valueOf(str));
        if(!queue.isEmpty()) root.left = deserializeHelper(queue);
        if(!queue.isEmpty()) root.right = deserializeHelper(queue);

        return root;
    }
}
