package String;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class RestoreIPAddress {

    // split between number in an IP address
    final char spliter = '.';

    /**
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     *
     * @see <a href="https://leetcode.com/problems/restore-ip-addresses/">LeetCode</a>
     *
     * @param s A String containing only digits
     * @return List, all possible valid IP address combinations
     */
    public List<String> restoreIPAddress(String s){
        // corner case
        if(s == null || s.length() < 4 || s.length() > 12) return new ArrayList<>();
        // create empty list as result
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length() - 3; i++){
            if(!isValidNum(s, 0, i)) continue;
            for(int j = i + 1; j < s.length() - 2; j++){
                if(!isValidNum(s, i + 1, j)) continue;
                for(int k = j + 1; k < s.length() - 1; k++){
                    if(!isValidNum(s, j + 1, k)) continue;
                    if(!isValidNum(s, k + 1, s.length() - 1)) continue;
                    // construct the IP string
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.substring(0, i + 1));
                    sb.append(spliter);
                    sb.append(s.substring(i + 1, j + 1));
                    sb.append(spliter);
                    sb.append(s.substring(j + 1, k + 1));
                    sb.append(spliter);
                    sb.append(s.substring(k + 1, s.length()));
                    // add into result
                    res.add(sb.toString());
                }
            }
        }
        // return result
        return res;
    }

    private boolean isValidNum(String s, int start, int end){
        if(end - start > 0 && s.charAt(start) == '0') return false;
        int val = Integer.valueOf(s.substring(start, end + 1));
        return (0 <= val && val <= 255);
    }
}
