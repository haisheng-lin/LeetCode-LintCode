package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class NextPermutation {
    /**
     * @see <a href="https://leetcode.com/problems/next-permutation/">LeetCode</a>
     *
     * @param nums An Integer array
     * @return void
     */
    public void nextPermutation(int[] nums) {
        // search first descending order from end
        int index1 = nums.length - 1;
        while(index1 > 0){
            if(nums[index1] > nums[index1 - 1]) break;
            index1--;
        }

        if(index1 > 0){
            for(int index2 = nums.length - 1; index2 >= index1; index2--){
                if(nums[index2] > nums[index1 - 1]){
                    swap(nums, index1 - 1, index2);
                    break;
                }
            }
        }

        // reverse
        int start = index1, end = nums.length - 1;
        while(start < end) swap(nums, start++, end--);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
