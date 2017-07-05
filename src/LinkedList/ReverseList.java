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

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Step 1: 找到需要reverse的链表的前一个节点
        ListNode p = dummy;
        for(int i = 0; i < m - 1; i++) p = p.next;

        // Step 2: reverse操作
        ListNode pre = p.next, cur = pre.next;
        for(int i = 0; i < n - m; i++){
            pre.next = cur.next;
            cur.next = p.next;
            p.next = cur;
            cur = pre.next;
        }

        return dummy.next;
    }
}
