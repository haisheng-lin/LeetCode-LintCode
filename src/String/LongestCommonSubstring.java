package String;

/**
 * Created by Lin on 2017/2/12.
 */
public class LongestCommonSubstring {
    /**
     * @see <a href="http://www.lintcode.com/en/problem/longest-common-substring/">LintCode</a>
     *
     * @param s A String
     * @param t A String
     * @return An Integer, the length of longest common substring in s and t
     */
    public int longestCommonSubstring(String s, String t){
        int max = 0;
        String longer, shorter;
        if(s.length() > t.length()){
            longer = s;
            shorter = t;
        }
        else{
            longer = t;
            shorter = s;
        }
        int index = 0;
        while(index < shorter.length()){
            boolean flag = false;
            if(index - max >= 0 && longer.contains(shorter.substring(index - max, index + 1))){
                max++;
                flag = true;
            }
            else if(index + max < shorter.length() && longer.contains(shorter.substring(index, index + max + 1))){
                max++;
                flag = true;
            }

            if(!flag) index++;
        }

        return max;
    }
}
