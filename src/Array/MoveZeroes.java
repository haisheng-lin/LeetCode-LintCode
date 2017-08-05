package Array;

/**
 * Created by Lin on 2017/8/3.
 */
public class MoveZeroes {
    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * @see <a href="https://leetcode.com/problems/move-zeroes/">LeetCode</a>
     *
     * @param nums An array of integers
     * @return Void
     */
    public void moveZeroes(int[] nums) {

        int insertPos = 0;

        // 把所有非0元素向前挪
        for(int num: nums){
            if(num != 0) nums[insertPos++] = num;
        }

        // 把所有0往后加
        while(insertPos < nums.length) nums[insertPos++] = 0;
    }
}
