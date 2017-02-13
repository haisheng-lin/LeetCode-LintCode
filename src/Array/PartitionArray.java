package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class PartitionArray {
    /**
     * @see <a href="http://www.lintcode.com/en/problem/partition-array/">LeetCode</a>
     *
     * @param nums The integer array you should partition
     * @param k As description
     * @return The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // this is the method applied in Quick Select
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            // search for next element that >= k
            while(i < nums.length && nums[i] < k) i++;
            if(i == nums.length) break;
            // search for next element that < k
            int j = i + 1;
            while(j < nums.length && nums[j] >= k) j++;
            if(j == nums.length) break;
            // swap
            swap(nums, i, j);
        }
        for(int i = 0; i < nums.length && nums[i] < k; i++) res++;

        return res;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
