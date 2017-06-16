package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/6/16.
 */
public class ReverseNodesInKGroup {
    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     *
     * @see <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/#/description">LeetCode</a>
     *
     * @param head Head of linked list.
     * @param k Positive integer and is less than or equal to the length of the linked list.
     * @return New head of list.
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy, pre = head;

        // step 1: count length
        int length = 0;
        ListNode p = head;
        while(p != null){
            length++;
            p = p.next;
        }

        // step 2: reverse
        for(int j = 0; j < length / k; j++){

            ListNode temp = pre;
            ListNode next = pre;

            for(int i = 0; i < k; i++) next = next.next;

            ListNode cur = pre.next;
            for(int i = 0; i < k - 1; i++){
                pre.next = cur.next;
                cur.next = pointer.next;
                pointer.next = cur;
                cur = pre.next;
            }

            pointer = temp;
            pre = next;
        }

        return dummy.next;
    }
}
