package Array;

/**
 * Created by Lin on 2017/2/28.
 */
public class WiggleSort {
    /**
     * Given an unsorted array nums, reorder it in-place such that
     * nums[0] <= nums[1] >= nums[2] <= nums[3]....
     * @see <a href="http://www.lintcode.com/en/problem/wiggle-sort/">LintCode</a>
     *
     * @param nums A list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(i % 2 == 0 && nums[i] > nums[i + 1]) swap(nums, i, i + 1);
            if(i % 2 == 1 && nums[i] < nums[i + 1]) swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
