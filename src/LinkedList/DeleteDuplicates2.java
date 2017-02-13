package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class DeleteDuplicates2 {
    /**
     * This method is to delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
     *
     * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">LeetCode</a>
     *
     * @param head Head of the linked list
     * @return Head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head){
        // corner case
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1), distinct = dummy;
        ListNode p = head;
        int pre = head.val;
        boolean repeat = false;
        while(p.next != null){
            if(p.next.val == pre){
                repeat = true;
                distinct.next = null;
            }
            else{
                if(!repeat){
                    distinct.next = p;
                    distinct = distinct.next;
                }
                if(p.next.next == null){
                    distinct.next = p.next;
                    distinct = distinct.next;
                }
                // reset
                repeat = false;
                pre = p.next.val;
            }
            p = p.next;
        }

        return dummy.next;
    }
}
