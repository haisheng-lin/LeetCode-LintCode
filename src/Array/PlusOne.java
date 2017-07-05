package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class PlusOne {
    /**
     * @see <a href="https://leetcode.com/problems/plus-one/">LeetCode</a>
     *
     * @param digits An Integer array
     * @return Integer array, after adding one
     */
    public int[] plusOne(int[] digits) {

        boolean add = true;

        for(int i = digits.length - 1; i >= 0; i--){

            if(add) digits[i]++;

            if(digits[i] == 10){
                digits[i] = 0;
                add = true;
            }
            else add = false;
        }

        // special case: if digits are originally 9, 99 or 999...
        if(add){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }

        return digits;
    }
}
