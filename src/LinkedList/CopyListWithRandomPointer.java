package LinkedList;

import ClassPackage.RandomListNode;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/7/12.
 */
public class CopyListWithRandomPointer {

    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */

    /**
     * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
     * Return a deep copy of the list.
     *
     * @see <a href="https://leetcode.com/problems/copy-list-with-random-pointer/#/description">LeetCode</a>
     *
     * @param head Head of the list
     * @return Deep copy of the list
     */
    public RandomListNode copyRandomList(RandomListNode head) {

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode p = head;
        while(p != null){
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }

        for(RandomListNode node: map.keySet()){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }

        return map.get(head);
    }
}
