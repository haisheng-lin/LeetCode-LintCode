package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class LetterOfPhone {

    // this is a phone map
    final String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    /**
     * Given a digit string, this method is to find all possible letter combinations that the number could represent.
     *
     * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">LeetCode</a>
     *
     * @param digits A String representing a number
     * @return All possible combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() > 0) dfs(res, digits, 0, new StringBuilder());
        return res;
    }

    private void dfs(List<String> res, String digits, int depth, StringBuilder sb){
        // terminal case
        if(depth == digits.length()){
            res.add(sb.toString());
            return;
        }

        int digit = digits.charAt(depth) - 48;
        for(int i = 0; i < map[digit].length(); i++){
            StringBuilder sbNext = new StringBuilder(sb);
            sbNext.append(map[digit].charAt(i));
            dfs(res, digits, depth + 1, sbNext);
        }
    }
}
