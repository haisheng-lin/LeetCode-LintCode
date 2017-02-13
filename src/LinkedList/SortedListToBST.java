package LinkedList;

import ClassPackage.ListNode;
import ClassPackage.TreeNode;

/**
 * Created by Lin on 2017/2/12.
 */
public class SortedListToBST {
    /**
     * Given a singly linked list where elements are sorted in ascending order, this method is to convert it to a height balanced BST.
     *
     * @see <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">LeetCode</a>
     *
     * @param head The first node of linked list.
     * @return A TreeNode
     */
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        node = head;
        // count size
        int size = 0;
        ListNode p = head;
        while(p != null){
            size++;
            p = p.next;
        }

        return helper(0, size - 1);
    }

    private TreeNode helper(int start, int end){
        // corner case
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode left = helper(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        TreeNode right = helper(mid , end);
        root.right = right;

        return root;
    }
}
