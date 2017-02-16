package Recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Lin on 2017/2/13.
 */
public class PalindromePartitioning {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * @see <a href="https://leetcode.com/problems/palindrome-partitioning/">LeetCode</a>
     *
     * @param s A String
     * @return all possible palindrome partitioning of s
     */
    public List<List<String>> partition(String s) {
        // create an empty list as result
        List<List<String>> res = new ArrayList<>();
        // invoke dfs method, LinkedList is more faster to do deletion
        dfs(res, new LinkedList<>(), s, 0);
        // return result
        return res;
    }

    private void dfs(List<List<String>> res, List<String> list, String s, int depth){
        // terminate case
        if(depth == s.length()) res.add(new ArrayList<>(list));

        for(int i = depth; i < s.length(); i++){
            if(isPalindome(s, depth, i)){
                list.add(s.substring(depth, i + 1));
                dfs(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindome(String s, int start, int end){

        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}
