package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/27.
 */
public class RemoveElements {
    /**
     * Remove all elements from a linked list of integers that have value val.
     *
     * @see <a href="https://leetcode.com/problems/remove-linked-list-elements">LeetCode</a>
     *
     * @param head Head of the sorted linked list
     * @param val Integer
     * @return Head of new linked list
     */
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;

        while(p.next != null){
            if(p.next.val == val)p.next = p.next.next;
            else p = p.next;
        }

        return dummy.next;
    }
}
