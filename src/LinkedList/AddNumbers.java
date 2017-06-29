package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class AddNumbers {
    /**
     * Given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit.
     * This method is to add the two numbers and return it as a linked list.
     *
     * @see <a href="https://leetcode.com/problems/add-two-numbers/">LeetCode</a>
     *
     * @param l1 The first list
     * @param l2 The second list
     * @return The sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, p1 = l1, p2 = l2;
        boolean add = false;

        while(p1 != null || p2 != null){
            int val = 0;
            if(p1 != null && p2 != null){
                val = add ? p1.val + p2.val + 1 : p1.val + p2.val;
                p1 = p1.next;
                p2 = p2.next;
            }
            else if(p1 != null && p2 == null){
                val = add ? p1.val + 1 : p1.val;
                p1 = p1.next;
            }
            else{
                val = add ? p2.val + 1 : p2.val;
                p2 = p2.next;
            }

            if(val >= 10){
                val -= 10;
                add = true;
            }
            else{
                add = false;
            }
            p.next = new ListNode(val);
            p = p.next;
        }
        // special case: see if the last one need to be added
        if(add) p.next = new ListNode(1);

        return dummy.next;
    }
}
