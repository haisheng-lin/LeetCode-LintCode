package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class RemoveElement {
    /**
     * @see <a href="https://leetcode.com/problems/remove-element/">LeetCode</a>
     *
     * @param nums List of integers
     * @param target An integer
     * @return New length after remove
     */
    public int removeElement(int[] nums, int target){
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
}
