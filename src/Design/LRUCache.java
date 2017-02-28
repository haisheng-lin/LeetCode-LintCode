package Design;

import java.util.Hashtable;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/2/15.
 */
public class LRUCache {

    /**
     * @see <a href="https://leetcode.com/problems/climbing-stairs/">LeetCode</a>
     * @see <a href="https://discuss.leetcode.com/topic/6613/java-hashtable-double-linked-list-with-a-touch-of-pseudo-nodes">LeetCode</a>
     */

    // double-linked list
    public class DoubleLinkedNode{
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode post;
    }

    /**
     * add the node right over the head, similar to Queue.offer()
     */
    private void addNode(DoubleLinkedNode node){
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * remove node out of the linked list
     */
    private void removeNode(DoubleLinkedNode node){
        DoubleLinkedNode pre = node.pre;
        DoubleLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * move the node to right over the head
     */
    private void moveToHead(DoubleLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode head, tail;
    private Hashtable<Integer, DoubleLinkedNode> cache; // or HashMap here
    private int capacity;

    public LRUCache(int capacity) {
        cache = new Hashtable<>();
        this.capacity = capacity;

        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.pre = null;
        head.post = tail;
        tail.pre = head;
        tail.post = null;
    }

    public int get(int key) {
        // corner case
        if(!cache.containsKey(key)) return -1;

        // update the node
        DoubleLinkedNode node = cache.get(key);
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        // add a new node into the list if it did not exist
        if(!cache.containsKey(key)){
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            cache.put(key, newNode);

            // remove the least currently used node and key
            if(cache.size() > capacity){
                int removeKey = tail.pre.key;
                removeNode(tail.pre);
                cache.remove(removeKey);
            }
        }

        // if exists, just update its value and move the node to the head
        else{
            DoubleLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }
}
