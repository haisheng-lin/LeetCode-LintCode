package String;

/**
 * Created by Lin on 2017/8/21.
 */
public class ReverseWordsInAStringIII {
    /**
     * Given a string, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order
     * Note: In the string, each word is separated by single space and there will not be any extra space in the string
     *
     * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">LeetCode</a>
     *
     * @param s A string
     * @return Reverse of the string word by word
     */
    public String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String word: words) {
            StringBuilder sbWord = new StringBuilder(word);
            if(sb.length() > 0) sb.append(' ');
            sb.append(sbWord.reverse().toString());
        }

        return sb.toString();
    }
}
