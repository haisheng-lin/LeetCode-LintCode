package LinkedList;

import ClassPackage.ListNode;
import java.util.Queue;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Lin on 2017/6/8.
 */
public class MergeKSortedLists {
    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/#/description">LintCode</a>
     *
     * @param lists Array of linked lists
     * @return New sorted lists
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        for(ListNode node : lists){
            if(node != null) queue.add(node);
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if(node.next != null) queue.add(node.next);
        }

        return dummy.next;
    }
}
