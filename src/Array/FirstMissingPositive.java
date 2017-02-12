package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class FirstMissingPositive {
    // https://leetcode.com/problems/first-missing-positive/
    /**
     * @param A: an array of integers
     * @return: an Integer
     */
    public int firstMissingPositive(int[] A){
        for(int i = 0; i < A.length;){
            if(A[i] != i + 1 && A[A[i] - 1] != A[i]) swap(A, i, A[i] - 1);
            else i++;
        }
        int index = 0;
        while(index < A.length && A[index] == index + 1) index++;

        return index + 1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
