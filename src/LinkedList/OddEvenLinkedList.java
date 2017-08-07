package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/8/6.
 */
public class OddEvenLinkedList {
    /**
     * Given a singly linked list, group all odd nodes together followed by the even nodes.
     * Please note here we are talking about the node number and not the value in the nodes.
     *
     * @see <a href="https://leetcode.com/problems/odd-even-linked-list/">LeetCode</a>
     *
     * @param head Head of linked list
     * @return Head of new linked list
     */
    public ListNode oddEvenList(ListNode head) {

        ListNode odd = new ListNode(-1), even = new ListNode(-1);
        ListNode p1 = odd, p2 = even, p = head;
        boolean isOdd = true;

        while(p != null){

            if(isOdd){
                p2.next = null;
                p1.next = p;
                p1 = p1.next;
            } else {
                p1.next = null;
                p2.next = p;
                p2 = p2.next;
            }

            p = p.next;
            isOdd = !isOdd;
        }

        p1.next = even.next;

        return odd.next;
    }
}
