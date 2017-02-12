package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class RemoveDuplicates {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    /**
     * @param nums: a array of integers, remove duplicates
     * @return : return an integer
     */
    public int removeDuplicates1(int[] nums){
        int length = (nums.length > 0) ? 1 : 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[length - 1]){
                nums[length++] = nums[i];
            }
        }

        return length;
    }

    /******************************* Separated Line *******************************/

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    /**
     * @param nums: a array of integers, allow duplicates most twice
     * @return : return an integer
     */
    public int removeDuplicates2(int[] nums) {
        int length = nums.length > 0 ? 1 : 0;
        int repeat = 0;
        for(int i = 1; i < nums.length; i++){
            // the element will be applied in case of:
            // case 1 : nums[i] > nums[length - 1]
            if(nums[i] > nums[length - 1]){
                nums[length++] = nums[i];
                repeat = 0;
            }
            // case 2 : the nums repeats only once before
            else if(repeat == 0){
                nums[length++] = nums[i];
                repeat++;
            }
        }

        return length;
    }
}
