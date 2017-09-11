package Array;

/**
 * Created by Lin on 2017/8/27.
 */
public class SetMismatch {
    /**
     * The set S originally contains numbers from 1 to n
     * But one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number
     * Given an array nums representing the data status of this set after the error
     * Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array
     *
     * @see <a href="https://leetcode.com/problems/set-mismatch/">LeetCode</a>
     *
     * @param nums Integer array
     * @return Array in which first number is duplicate number and the second one is the number that missing
     */
    public int[] findErrorNums(int[] nums) {

        int[] res = new int[2];

        for(int i = 0; i < nums.length;) {
            if(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
            else i++;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                res[0] = nums[i];
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
