package Array;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/2/12.
 */
public class ProductExcludeItself {
    // https://leetcode.com/problems/product-of-array-except-self/
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> A){
        List<Long> list = new ArrayList<>();
        long[] products = new long[A.size()];
        // product from left
        long left = 1;
        for(int i = 0; i < A.size(); i++){
            products[i] = left;
            left *= A.get(i);
        }
        // product from right
        long right = 1;
        for(int i = A.size() - 1; i >= 0; i--){
            products[i] *= right;
            right *= A.get(i);
        }
        for(long num : products) list.add(num);

        return list;
    }
}
