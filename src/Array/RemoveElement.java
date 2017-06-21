package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class RemoveElement {
    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * @see <a href="https://leetcode.com/problems/remove-element/">LeetCode</a>
     *
     * @param nums List of integers
     * @param target An integer
     * @return New length after remove
     */
    public int removeElement1(int[] nums, int target){
        // corner case
        if(nums == null || nums.length == 0) return 0;

        int length = 0;
        int eleIndex = 0, tarIndex = 0;
        while(eleIndex < nums.length){
            // search next target
            while(tarIndex < nums.length && nums[tarIndex] != target) tarIndex++;
            if(tarIndex == nums.length) break;
            // search next element whose value is not target
            if(eleIndex <= tarIndex) eleIndex = tarIndex + 1;
            while(eleIndex < nums.length && nums[eleIndex] == target) eleIndex++;
            if(eleIndex == nums.length) break;
            // swap
            swap(nums, eleIndex, tarIndex);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) break;
            length++;
        }

        return length;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * @see <a href="https://leetcode.com/problems/remove-element/">LeetCode</a>
     *
     * @param nums List of integers
     * @param val An integer
     * @return New length after remove
     */
    public int removeElement2(int[] nums, int val) {
        int length = 0;
        // step 1: count length
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) length++;
        }
        // step 2: remove val
        int start = length;
        for(int i = 0; i < length; i++){
            if(nums[i] == val){
                // search next element that not equals to val
                while(start < nums.length && nums[start] == val) start++;
                if(start == nums.length) break;
                nums[i] = nums[start++];
            }
        }

        return length;
    }
}
