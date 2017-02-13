package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class RotateList {
    /**
     * This method is to rotate the list to the right by k places, where k is non-negative.
     *
     * @see <a href="https://leetcode.com/problems/rotate-list/">LeetCode</a>
     *
     * @param head Head of linked List
     * @param k An Integer
     * @return New head of list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // corner case
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        // 1. count size
        int size = 0;
        ListNode p = head;
        while(p != null){
            size++;
            p = p.next;
        }
        k = k % size;
        // 2. search kth node from the end
        ListNode last = dummy;
        for(int i = 0; i < size - k; i++) last = last.next;
        ListNode node = last.next;
        // 3. obtain the tail node and rotate list
        if(node != null){
            ListNode tail = node;
            while(tail.next != null) tail = tail.next;
            last.next = null;
            dummy.next = node;
            tail.next = head;
        }

        return dummy.next;
    }
}
