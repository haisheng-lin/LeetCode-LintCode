package Design;

/**
 * Created by Lin on 2017/7/31.
 */
public class ImplementTrie {

    /** @see <a href="https://leetcode.com/problems/implement-trie-prefix-tree">LeetCode</a> */

    TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode p = root;
        char[] charArray = word.toCharArray();

        for(char c: charArray){
            if(p.next[c - 'a'] == null) p.next[c - 'a'] = new TrieNode();
            p = p.next[c - 'a'];
        }

        p.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode p = root;
        char[] charArray = word.toCharArray();

        for(char c: charArray){
            if(p.next[c - 'a'] == null) return false;
            p = p.next[c - 'a'];
        }

        return p.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode p = root;
        char[] charArray = prefix.toCharArray();

        for(char c: charArray){
            if(p.next[c - 'a'] == null) return false;
            p = p.next[c - 'a'];
        }

        return true;
    }

    public class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean end = false;
    }
}
