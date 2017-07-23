package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class SortList {
    /**
     * This method is to sort a linked list in O(n log n) time using constant space complexity.
     *
     * @see <a href="https://leetcode.com/problems/sort-list/">LeetCode</a>
     *
     * @param head The head of linked list.
     * @return Head of the sorted linked list.
     */
    public ListNode sortList(ListNode head) {
        // corner case
        if(head == null || head.next == null) return head;

        // Step 1: partition the list
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode first = head, second = slow.next;
        slow.next = null;

        // Step 2: sort each sub-list
        ListNode l1 = sortList(first), l2 = sortList(second);

        // Step 3: merge sub-list
        return mergeList(l1, l2);
    }

    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, p1 = l1, p2 = l2;

        while(p1 != null || p2 != null){
            if(p2 == null || (p1 != null && p1.val <= p2.val)){
                p.next = p1;
                p1 = p1.next;
            }
            else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        return dummy.next;
    }
}
