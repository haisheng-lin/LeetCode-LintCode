package Recursion;

/**
 * Created by Lin on 2017/2/12.
 */
public class WordSearch {
    /**
     * This method is to find if the word exists in the given grid
     *
     * @see <a href="https://leetcode.com/problems/word-search/">LeetCode</a>
     *
     * @param board A list of lists of character
     * @param word A string
     * @return: True if word exists, else false
     */
    public boolean wordSearch(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(dfs(board, word, i , j, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int depth){
        // true case
        if(depth == word.length()) return true;
        // check boundary
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length) return false;
        if(word.charAt(depth) != board[row][col]) return false;
        // invalid
        board[row][col] ^= 256;
        boolean flag = dfs(board, word, row - 1, col, depth + 1) ||
                dfs(board, word, row + 1, col, depth + 1) ||
                dfs(board, word, row, col - 1, depth + 1) ||
                dfs(board, word, row, col + 1, depth + 1);
        // valid
        board[row][col] ^= 256;

        return flag;
    }
}
