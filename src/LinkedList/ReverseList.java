package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class ReverseList {
    /**
     * This method is to Reverse a linked list.
     *
     * @see <a href="http://www.lintcode.com/en/problem/reverse-linked-list/">LintCode</a>
     *
     * @param head The head of linked list.
     * @return The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // corner case
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head, cur = head.next;
        while(cur != null){
            pre.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = pre.next;
        }

        return dummy.next;
    }

    /**
     * This method is to reverse a linked list from position m to n.
     *
     * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/">LeetCode</a>
     *
     * @param head Head of ListNode
     * @param m Start point of the reverse part
     * @param n End point of the reverse part
     * @return New head of list
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // create dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // find the last node on LHS, the first node on RHS of the reverse part
        ListNode left = dummy, right = dummy;
        for(int i = 1; i < m; i++) left = left.next;
        for(int i = 1; i <= n + 1; i++) right = right.next;
        // reverse
        ListNode pre = left.next, cur = pre.next;
        while(cur != right){
            pre.next = cur.next;
            cur.next = left.next;
            left.next = cur;
            cur = pre.next;
        }
        // return result
        return dummy.next;
    }
}
