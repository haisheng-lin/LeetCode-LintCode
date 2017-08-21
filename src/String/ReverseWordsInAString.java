package String;

/**
 * Created by Lin on 2017/7/14.
 */
public class ReverseWordsInAString {
    /**
     * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/#/description">LeetCode</a>
     *
     * @param s A string
     * @return Reverse of the string word by word
     */
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        int insertPos = 0;

        // clear leading and trailing space
        int start = 0, end = s.length() - 1;
        while(start <= end && s.charAt(start) == ' ') start++;
        while(start <= end && s.charAt(end) == ' ') end--;

        s = s.substring(start, end + 1);

        // reverse the string
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == ' '){
                if(flag) continue;
                insertPos = 0;
                flag = true;
                sb.insert(insertPos, cur);
            } else{
                flag = false;
                sb.insert(insertPos++, cur);
            }
        }

        return sb.toString();
    }

    /**
     * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/#/description">LeetCode</a>
     *
     * @param s A string
     * @return Reverse of the string word by word
     *
     */
    public String reverseWords2(String s) {

        StringBuilder sb = new StringBuilder();
        int start = 0;
        boolean findStart = false;

        for(int end = 0; end < s.length(); end++){

            if(s.charAt(end) == ' '){
                // search the first index of a word
                if(!findStart) start++;

                // the end of a word
                else{
                    if(sb.length() > 0) sb.insert(0, ' ');
                    sb.insert(0, s.substring(start, end));
                    findStart = false;
                    start = end + 1;
                }
            }

            else{
                findStart = true;
                // boundary
                if(end + 1 == s.length()){
                    if(sb.length() > 0) sb.insert(0, ' ');
                    sb.insert(0, s.substring(start, end + 1));
                }
            }
        }

        return sb.toString();
    }
}
