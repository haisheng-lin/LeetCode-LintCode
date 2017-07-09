package BinaryTree;

import ClassPackage.TreeLinkNode;

/**
 * Created by Lin on 2017/7/8.
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     *     int val;
     *     TreeLinkNode left, right, next;
     *     TreeLinkNode(int x) { val = x; }
     * }
     */

    /**
     * Populate each next pointer to point to its next right node.
     * If there is no next right node, the next pointer should be set to NULL.
     *
     * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/#/description">LeetCode</a>
     *
     * @param root The root of binary tree.
     * @return void
     */
    public void connect(TreeLinkNode root) {

        TreeLinkNode pre = root;

        // BFS
        while(pre != null){
            TreeLinkNode  node = pre;
            TreeLinkNode head = new TreeLinkNode(0);
            TreeLinkNode p = head;

            while(node != null){
                if(node.left != null){
                    p.next = node.left;
                    p = p.next;
                }

                if(node.right != null){
                    p.next = node.right;
                    p = p.next;
                }

                node = node.next;
            }

            pre = head.next;
        }
    }
}
