package Array;

/**
 * Created by Lin on 2017/8/4.
 */
public class FindTheDuplicateNumber {
    /**
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive).
     * Assume that there is only one duplicate number, find the duplicate one.
     *
     * @see <a href="https://leetcode.com/problems/find-the-duplicate-number/">LeetCode</a>
     *
     * @param nums An array of integers
     * @return Duplicate number
     */
    public int findDuplicate(int[] nums) {

        for(int i = 0; i < nums.length;){
            if(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
            else i++;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1) return nums[i];
        }

        return 0;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
