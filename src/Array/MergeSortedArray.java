package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class MergeSortedArray {
    // https://leetcode.com/problems/merge-sorted-array/
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray1(int[] A, int m, int[] B, int n) {
        int index = m + n - 1;
        int ap = m - 1, bp = n - 1;
        while(ap >= 0 || bp >= 0){
            if(bp < 0 || (ap >= 0 && A[ap] >= B[bp])) A[index--] = A[ap--];
            else A[index--] = B[bp--];
        }
    }

    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray2(int[] A, int[] B){
        int[] res = new int[A.length + B.length];
        int ap = 0, bp = 0, p = 0;
        while(ap < A.length || bp < B.length){
            if(bp >= B.length || (ap < A.length && A[ap] <= B[bp])) res[p++] = A[ap++];
            else res[p++] = B[bp++];
        }

        return res;
    }
}
