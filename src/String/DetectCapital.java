package String;

/**
 * Created by Lin on 2017/8/17.
 */
public class DetectCapital {
    /**
     * Given a word, you need to judge whether the usage of capitals in it is right or not.
     *
     * We define the usage of capitals in a word to be right when one of the following cases holds:
     * 1. All letters in this word are capitals, like "USA".
     * 2. All letters in this word are not capitals, like "leetcode".
     * 3. Only the first letter in this word is capital if it has more than one letter, like "Google".
     *
     * @see <a href="https://leetcode.com/problems/detect-capital/">LeetCode</a>
     *
     * @param word String
     * @return True if word is right and false if word is not right
     */
    public boolean detectCapitalUse(String word) {

        boolean firstIsUpper = false, secondIsUpper = false;

        for(int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if('A' <= cur && cur <= 'Z') {
                if(i == 0) {
                    firstIsUpper = true;
                } else if(i == 1) {
                    if(!firstIsUpper) return false;
                    secondIsUpper = true;
                } else if(!secondIsUpper) {
                    return false;
                }
            } else {
                if(firstIsUpper && secondIsUpper) return false;
            }
        }

        return true;
    }
}
