package Array;

import java.util.Arrays;

/**
 * Created by Lin on 2017/2/15.
 */
public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        // corner case
        if(nums == null || nums.length == 0) return;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
