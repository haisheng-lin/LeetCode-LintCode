package Others;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lin on 2017/2/27.
 */
public class HappyNumber {
    /**
     * @see <a href="https://leetcode.com/problems/happy-number/?tab=Description">LeetCode</a>
     *
     * @param n Integer
     * @return True if n is happy number, else false
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int curNum = n;
        // break if the set begins looping
        while(set.add(curNum)){
            // true if the num is 1
            if(curNum == 1) return true;
            int next = 0;
            // create next number
            while(curNum != 0){
                next += (curNum % 10) * (curNum % 10);
                curNum /= 10;
            }
            curNum = next;
        }

        return false;
    }
}
