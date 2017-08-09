package BinaryTree;

/**
 * Created by Lin on 2017/8/8.
 */
public class VerifyPreorderSerializationOfBinaryTree {
    /**
     * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree.
     * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
     *
     * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">LeetCode</a>
     *
     * @param preorder Serialization of preorder of a binary tree
     * @return True if the preorder serialization is valid, else false.
     */
    public boolean isValidSerialization(String preorder) {

        String[] nodes = preorder.split(",");
        int diff = 1;

        for(String node: nodes){
            if(--diff < 0) return false;
            if(!node.equals("#")) diff += 2;
        }

        return diff == 0;
    }
}
