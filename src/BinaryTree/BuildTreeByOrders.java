package BinaryTree;

import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/2/13.
 */
public class BuildTreeByOrders {

    /**
     * Here is an example for understanding the problem. Given a tree as follows:
     *
     *                       1
     *                   /      \
     *                  2        3
     *                /  \     /  \
     *               4   5    6    7
     *
     * preorder:   1, 2, 4, 5, 3, 6, 7
     * inorder:    4, 2, 5, 1, 6, 3, 7
     * postorder:  4, 5, 2, 6, 7, 3, 1
     *
     * Obviously, the root of this tree is 1, which is in the start point of preorder, as well as end point of postorder
     * Left subtree is (2, 4, 5) in preorder, (4, 2, 5) in inorder, (4, 5, 2) in postorder
     * Right subtree is (3, 6, 7) in preorder, (6, 3, 7) in inorder, (6, 7, 3) in postorder
     *
     * So we need to find out where "1" (root) is in inorder, then partition the orders for left and right subtree
     * And repeat the steps until start point is greater than the end point
     */

    /**
     * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">LeetCode</a>
     *
     * @param preorder An array storing values of TreeNode in preorder
     * @param inorder An array storing values of TreeNode in inorder
     * @return Root of the tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        // corner case
        if(pStart > pEnd) return null;
        // root of the tree (subtree)
        TreeNode root = new TreeNode(preorder[pStart]);
        // search the root in inorder array
        int index = 0;
        while(index < inorder.length){
            if(root.val == inorder[index]) break;
            index++;
        }
        // do next recursion
        root.left = helper(preorder, pStart + 1, pStart + (index - iStart), inorder, iStart, index - 1);
        root.right = helper(preorder, pStart + (index - iStart) + 1, pEnd, inorder, index + 1, iEnd);
        // return result
        return root;
    }

    /**
     * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">LeetCode</a>
     *
     * @param inorder An array storing values of TreeNode in inorder
     * @param postorder An array storing values of TreeNode in postorder
     * @return Root of the tree
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return helper2(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper2(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd){
        // corner case
        if(pStart > pEnd) return null;
        // root of the current tree (subtree)
        TreeNode root = new TreeNode(postorder[pEnd]);
        // search the root in inorder array
        int index = 0;
        while(index < inorder.length){
            if(root.val == inorder[index]) break;
            index++;
        }
        // do next recursion
        root.left = helper2(inorder, iStart, index - 1, postorder, pStart, pStart + (index - iStart) - 1);
        root.right = helper2(inorder, index + 1, iEnd, postorder, pStart + (index - iStart), pEnd - 1);
        // return result
        return root;
    }
}
