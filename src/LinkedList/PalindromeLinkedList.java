package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/7/31.
 */
public class PalindromeLinkedList {
    /**
     * This method is to determine if the given single linked list is a palindrome.
     *
     * @see <a href="https://leetcode.com/problems/palindrome-linked-list">LeetCode</a>
     *
     * @param head Head of the sorted linked list
     * @return True if the list is palindromic, else false
     */
    public boolean isPalindrome(ListNode head) {

        // corner case
        if(head == null || head.next == null) return true;

        // Step 1：把链表分成两半
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2：反转第二部分
        ListNode pre = slow.next, cur = pre.next;
        while(cur != null){
            pre.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = pre.next;
        }

        // Step 3：把第二部分合并到第一部分
        ListNode p = head;
        while(slow.next != null && p != null){
            ListNode temp = slow.next;
            slow.next = slow.next.next;
            temp.next = p.next;
            p.next = temp;
            p = p.next.next;
        }

        // Step 4：一对对地检查链表
        p = head;
        while(p != null && p.next != null){
            if(p.val != p.next.val) return false;
            p = p.next.next;
        }

        return true;
    }
}
