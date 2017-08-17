package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class WordSearchII {
    /**
     * This method is used to find all words in the board, given a 2D board and a list of words from the dictionary.
     *
     * @see <a href="https://leetcode.com/problems/word-search-ii/">LeetCode</a>
     *
     * @param board A list of lists of character
     * @param words A list of words
     * @return List of words existed in the dictionary
     */
    public List<String> wordSearch2(char[][] board, String[] words) {

        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                dfs(board, res, root, row, col);
            }
        }

        return res;
    }

    private void dfs(char[][] board, List<String> res, TrieNode root, int row, int col){

        char c = board[row][col];
        if(c == '#' || root.next[c - 'a'] == null) return;

        root = root.next[c - 'a'];

        // 找到一个完整的word
        if(root.word != null){
            res.add(root.word);
            // 去除duplicate
            root.word = null;
        }

        // 无效化字符
        board[row][col] = '#';

        // 下一轮递归
        if(row > 0) dfs(board, res, root, row - 1, col);
        if(row < board.length - 1) dfs(board, res, root, row + 1, col);
        if(col > 0) dfs(board, res, root, row, col - 1);
        if(col < board[row].length - 1) dfs(board, res, root, row, col + 1);

        // 重新有效化字符
        board[row][col] = c;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();

        for(String word : words){
            TrieNode p = root;
            for(char c : word.toCharArray()){
                if(p.next[c - 'a'] == null) p.next[c - 'a'] = new TrieNode();
                p = p.next[c - 'a'];
            }
            p.word = word;
        }

        return root;
    }

    public class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
