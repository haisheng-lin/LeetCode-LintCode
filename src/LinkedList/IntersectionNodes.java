package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/24.
 */
public class IntersectionNodes {
    /**
     * Find the node at which the intersection of two singly linked lists begins
     * Your code should preferably run in O(n) time and use only O(1) memory
     *
     * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/?tab=Description">LeetCode</a>
     *
     * @param headA Head of a linked list.
     * @param headB Head of a linked list.
     * @return Head of intersection of two linked lists
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // get length of two lists
        int lengthA = getLength(headA), lengthB = getLength(headB);

        // move headA and headB to the same start point
        while(lengthA > lengthB){
            headA = headA.next;
            lengthA--;
        }
        while(lengthA < lengthB){
            headB = headB.next;
            lengthB--;
        }

        // find the intersection till end
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    /**
     * Get the length of the linked list
     */
    private int getLength(ListNode head){
        int length = 0;
        ListNode p = head;

        while(p != null){
            length++;
            p = p.next;
        }

        return length;
    }
}
