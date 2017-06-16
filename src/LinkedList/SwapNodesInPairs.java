package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/6/9.
 */
public class SwapNodesInPairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     *
     * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/#/description">LeetCode</a>
     *
     * @param head Head of linked list.
     * @return New head of list.
     */
    public ListNode swapPairs(ListNode head) {
        // corner case
        if(head == null) return null;

        ListNode dummy = new ListNode(-1), p = dummy;
        dummy.next = head;

        // make sure next pair of nodes available
        while(p.next != null && p.next.next != null){
            ListNode pre = p.next, cur = p.next.next;
            pre.next = cur.next;
            p.next = cur;
            cur.next = pre;
            p = p.next.next;
        }

        return dummy.next;
    }
}
