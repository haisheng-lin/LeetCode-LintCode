package Array;

/**
 * Created by Lin on 2017/8/2.
 */
public class MissingNumber {
    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n
     * Find the one that is missing from the array.
     *
     * @see <a href="https://leetcode.com/problems/missing-number/">LeetCode</a>
     *
     * @param nums An array of integers
     * @return Missing integer from the array
     */
    public int missingNumber(int[] nums) {

        for(int i = 0; i < nums.length;){
            if(nums[i] != i && nums[i] < nums.length) swap(nums, i, nums[i]);
            else i++;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i) return i;
        }

        return nums.length;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
