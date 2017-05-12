package BinaryTree;

import ClassPackage.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/2/27.
 */
public class FindMode {
    /**
     * Find all the mode(s) (the most frequently occurred element) in the given BST
     * @see <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/?tab=Description">LeetCode</a>
     *
     * @param root Root of the tree
     * @return Array in which elements are most frequently occurred
     */
    public int[] findMode(TreeNode root) {
        int[] res;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // store data
        storeData(root, map);
        // find maximum frequency
        int fre = 0;
        for(int frequency: map.values()) fre = Math.max(fre, frequency);
        // find element with maximum frequency
        for(int key: map.keySet()){
            if(map.get(key) == fre) list.add(key);
        }
        // convert list to array
        res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);

        return res;
    }

    private void storeData(TreeNode root, Map<Integer, Integer> map){
        // terminate case
        if(root == null) return;
        // map value to frequency
        if(map.containsKey(root.val)) map.put(root.val, map.get(root.val) + 1);
        else map.put(root.val, 1);
        // next recursion
        storeData(root.left, map);
        storeData(root.right, map);
    }
}
