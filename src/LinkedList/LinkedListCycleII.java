package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/7/12.
 */
public class LinkedListCycleII {
    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii/#/description">LeetCode</a>
     *
     * @param head The first node of linked list.
     * @return Null if no cycle, else return the node where the cycle begins
     */
    public ListNode detectCycle(ListNode head) {
        // corner case
        if(head == null) return null;

        ListNode slow = head, fast = head;
        boolean hasCycle = false;

        // 1. 检查是否有环
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle) return null;

        // 2. 找出环口
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
