package LinkedList;

import ClassPackage.ListNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class PartitionList {
    /**
     * This method is to partition a given list such that all nodes less than x come before nodes greater than or equal to x.
     *
     * @see <a href="http://www.lintcode.com/en/problem/partition-list/">LintCode</a>
     *
     * @param head The first node of linked list.
     * @param x An integer
     * @return New head of the list
     */
    public ListNode partition(ListNode head, int x) {

        ListNode large = new ListNode(-1), small = new ListNode(-1);
        ListNode p = head, lp = large, sp = small;

        while(p != null){
            if(p.val < x){
                sp.next = p;
                sp = sp.next;
            }
            else{
                lp.next = p;
                lp = lp.next;
            }
            p = p.next;
        }

        lp.next = null;
        sp.next = large.next;

        return small.next;
    }
}
