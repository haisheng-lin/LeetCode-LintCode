package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/7/12.
 */
public class ReorderList {
    /**
     * Given a singly linked list L: L0?L1?…?Ln-1?Ln
     * reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
     *
     * @see <a href="https://leetcode.com/problems/reorder-list/#/description">LeetCode</a>
     *
     * @param head The first list
     * @return Head of reordered list
     */
    public void reorderList(ListNode head) {
        // corner case
        if(head == null || head.next == null) return;

        // Step 1: 逆转后半部分
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = slow.next, cur = pre.next;
        while(cur != null){
            pre.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = pre.next;
        }

        // Step 2: 把后半部分的节点插到前半部分
        ListNode p1 = head, p2 = slow.next;
        while(p1 != slow){
            slow.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p1.next.next;
            p2 = slow.next;
        }
    }
}
