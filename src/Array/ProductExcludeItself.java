package Array;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class ProductExcludeItself {
    /**
     * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">LeetCode</a>
     *
     * @param nums An integers array
     * @return An array "output" such that output[i] is equal to the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {

        int[] product = new int[nums.length];
        int left = 1, right = 1;

        // 乘以元素以左的部分
        for(int i = 0; i < nums.length; i++){
            product[i] = left;
            left *= nums[i];
        }

        // 乘以元素以右的部分
        for(int i = nums.length - 1; i >= 0; i--){
            product[i] *= right;
            right *= nums[i];
        }

        return product;
    }
}
