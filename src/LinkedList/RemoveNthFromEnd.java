package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class RemoveNthFromEnd {
    /**
     * This method is to remove the nth node from the end of list and return its head.
     *
     * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">LeetCode</a>
     *
     * @param head The first node of linked list.
     * @param n An integer.
     * @return New head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // dummy node is necessary
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 1. count size
        ListNode p = head;
        int size = 0;
        while(p != null){
            size++;
            p = p.next;
        }
        // 2. find the nth node from the end and remove it
        p = dummy;
        for(int i = 0; i < size - n; i++) p = p.next;
        p.next = p.next.next;

        return dummy.next;
    }
}
