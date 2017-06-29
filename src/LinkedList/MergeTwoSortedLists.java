package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/6/8.
 */
public class MergeTwoSortedLists {
    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     *
     * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/#/description">LeetCode</a>
     *
     * @param l1 The first linked list.
     * @param l2 The second linked list.
     * @return New head of sorted list.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, p1 = l1, p2 = l2;

        while(p1 != null || p2 != null){

            int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE;

            if(p1 != null) num1 = p1.val;
            if(p2 != null) num2 = p2.val;

            // next node is in list1
            if(p2 == null || (p1 != null && num1 <= num2)){
                p.next = p1;
                p1 = p1.next;
            }

            // next node is in list2
            else{
                p.next = p2;
                p2 = p2.next;
            }

            p = p.next;
        }

        return dummy.next;
    }
}
