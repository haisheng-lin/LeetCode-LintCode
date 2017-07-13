package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class LinkedListCycle {
    /**
     * This method is to determine if it has a cycle in it.
     *
     * @see <a href="https://leetcode.com/problems/linked-list-cycle/">LeetCode</a>
     *
     * @param head The first node of linked list.
     * @return True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // corner case
        if(head == null) return true;

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }

        return false;
    }
}
