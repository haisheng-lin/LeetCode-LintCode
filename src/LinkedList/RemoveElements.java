package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/27.
 */
public class RemoveElements {
    /**
     * Remove all elements from a linked list of integers that have value val.
     *
     * @see <a href="https://leetcode.com/problems/remove-linked-list-elements/?tab=Description">LeetCode</a>
     *
     * @param head Head of the sorted linked list
     * @param val Integer
     * @return Head of new linked list
     */
    public ListNode removeElements(ListNode head, int val) {
        // dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // pointer of result list and given list
        ListNode pre = dummy;
        while(pre != null && pre.next != null){
            if(pre.next.val == val) pre.next = pre.next.next;
            else pre = pre.next;
        }
        // return result
        return dummy.next;
    }
}
