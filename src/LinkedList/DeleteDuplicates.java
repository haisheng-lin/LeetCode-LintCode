package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class DeleteDuplicates {
    /**
     * This method is to delete all duplicates such that each element appear only once.
     *
     * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">LeetCode</a>
     *
     * @param head Head of the sorted linked list
     * @return Head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // corner case
        if(head == null) return null;

        ListNode p = head;
        int pre = head.val;
        while(p.next != null){
            if(p.next.val == pre) p.next = p.next.next;
            else{
                p = p.next;
                pre = p.val;
            }
        }

        return head;
    }
}
