package Recursion;

/**
 * Created by Lin on 2017/2/13.
 */
public class PalindromePartitioningII {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return the minimum cuts needed for a palindrome partitioning of s.
     *
     * @see <a href="https://leetcode.com/problems/palindrome-partitioning-ii/">LeetCode</a>
     *
     * @param s A String
     * @return the minimum cuts needed
     */
    public int minCut(String s) {
        // corner case
        if(s.length() == 0) return 0;

        // number of cuts for the first k characters
        int[] cut = new int[s.length() + 1];

        for(int i = 0; i <= cut.length; i++) cut[i] = i - 1;

        for(int i = 0; i < s.length(); i++){
            // odd length palindrome
            for(int j = 0; i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j); j++){
                cut[i+j+1] = Math.min(cut[i+j+1], 1 + cut[i - j]);
            }
            // even length palindrome
            for(int j = 1; i - j + 1>= 0 && i + j < s.length() && s.charAt(i - j + 1) == s.charAt(i + j); j++){
                cut[i+j+1] = Math.min(cut[i+j+1], 1 + cut[i - j + 1]);
            }
        }

        return cut[s.length()];
    }
}
