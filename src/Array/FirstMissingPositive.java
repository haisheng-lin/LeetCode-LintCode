package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class FirstMissingPositive {
    /**
     * @see <a href="https://leetcode.com/problems/first-missing-positive/">LeetCode</a>
     *
     * @param nums An array of integers
     * @return An Integer
     */
    public int firstMissingPositive(int[] nums){

        // step 1: 把尽量多的元素放到合适的位置上
        for(int i = 0; i < nums.length;){
            if(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
            else i++;
        }

        // step 2: 遍历数组，找出第一个不符的位置
        int index = 0;
        while(index < nums.length && nums[index] == index + 1) index++;

        return index + 1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
