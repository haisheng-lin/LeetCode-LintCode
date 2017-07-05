package Array;

/**
 * Created by Lin on 2017/2/12.
 */
public class MergeSortedArray {
    /**
     * @see <a href="https://leetcode.com/problems/merge-sorted-array//">LeetCode</a>
     *
     * @param nums1 Sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param nums2 Sorted integer array B which has n elements
     * @return void
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = nums1.length - 1;
        int p1 = m - 1, p2 = n - 1;

        while(p1 >= 0 || p2 >= 0){
            if(p2 < 0 || (p1 >= 0 && nums1[p1] >= nums2[p2])) nums1[index--] = nums1[p1--];
            else nums1[index--] = nums2[p2--];
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
