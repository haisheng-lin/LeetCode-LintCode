package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/8/1.
 */
public class DeleteNode {
    /**
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     *
     * @see <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">LeetCode</a>
     *
     * @param node The node to be deleted
     * @return Void
     */
    public void deleteNode(ListNode node) {

        if(node.next == null) node = null;
        else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
