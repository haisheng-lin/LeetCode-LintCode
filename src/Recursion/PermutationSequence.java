package Recursion;

/**
 * Created by Lin on 2017/2/12.
 */
public class PermutationSequence {
    /**
     * This method is to find the kth permutation sequence, given n and k.
     *
     * @see <a href="https://leetcode.com/problems/permutation-sequence/">LeetCode</a>
     *
     * @param n An Integer between 1 and 9 inclusive
     * @param k An Integer
     * @return String, in kth sequence
     */
    public String getPermutation(int n, int k) {
        // construct a StringBuilder as result
        StringBuilder sb = new StringBuilder();
        // construct an array to store data
        int[] array = new int[n];
        // initialize the array in first sequence
        for(int i = 1; i <= n; i++) array[i - 1] = i;
        // invoke helper method
        helper(array, k);
        // construct a String from array
        for(int num: array) sb.append(num);
        // return result
        return sb.toString();
    }

    /**
     * @param array: an Integer array
     * @param k: an Integer
     * @return: void, find next permutation
     * https://leetcode.com/problems/next-permutation/
     */
    private void helper(int[] array, int k){
        // loop for k times
        for(int i = k; i > 1; i--){
            // search for first ascending order from the end
            int index1 = array.length - 1;
            while(index1 > 0){
                if(array[index1] > array[index1 - 1]) break;
                index1--;
            }
            if(index1 > 0){
                // search for first number that greater than the index and swap
                for(int index2 = array.length - 1; index2 >= index1; index2--){
                    if(array[index2] > array[index1 - 1]){
                        swap(array, index1 - 1, index2);
                        break;
                    }
                }
            }
            // reverse the part on the RHS of the index cause it should be in descending order
            int start = index1, end = array.length - 1;
            while(start < end) swap(array, start++, end--);
        }
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
