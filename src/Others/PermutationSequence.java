package Others;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/6/28.
 */
public class PermutationSequence {

    /***************************************** Best Version *****************************************/

    /**
     * Given n and k, return the kth permutation sequence.
     *
     * @see <a href="https://leetcode.com/problems/permutation-sequence/#/description">LeetCode</a>
     *
     * @param n Integer
     * @param k Integer
     * @return The kth permutation sequence
     */
    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int[] factorial = new int[n + 1];
        int sum = 1;
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial = [1, 1, 2, 6, 24, ...., n!]

        // create a list of numbers to get indices
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++) nums.add(i);
        // nums = [1, 2, ... , n]

        k--;

        for(int i = 1; i <= n; i++){
            int pos = k / factorial[n - i];
            sb.append(String.valueOf(nums.get(pos)));
            nums.remove(pos);
            k -= pos * factorial[n - i];
        }

        return sb.toString();
    }

    /***************************************** My Version *****************************************/

    /**
     * Given n and k, return the kth permutation sequence.
     *
     * @see <a href="https://leetcode.com/problems/permutation-sequence/#/description">LeetCode</a>
     *
     * @param n Integer
     * @param k Integer
     * @return The kth permutation sequence
     */
    public String getPermutation2(int n, int k) {
        StringBuilder sb = new StringBuilder();

        int[] nums = new int[n];
        for(int i = 1; i <= n; i++) nums[i - 1] = i;

        for(int i = 1; i <= k - 1; i++){
            int index1 = nums.length - 1;
            while(index1 > 0){
                if(nums[index1] > nums[index1 - 1]) break;
                index1--;
            }

            if(index1 > 0){
                int index2 = nums.length - 1;
                while(index2 >= index1){
                    if(nums[index2] > nums[index1 - 1]) break;
                    index2--;
                }

                swap(nums, index1 - 1, index2);
            }

            int start = index1, end = nums.length - 1;
            while(start < end) swap(nums, start++, end--);
        }

        for(int num: nums) sb.append(String.valueOf(num));

        return sb.toString();
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
