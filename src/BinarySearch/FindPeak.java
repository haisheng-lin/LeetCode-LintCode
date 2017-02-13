package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class FindPeak {
    /**
     * @see <a href="https://leetcode.com/problems/find-peak-element/">LeetCode</a>
     *
     * @param A An integers array.
     * @return Any of peek positions
     */
    public int findPeak(int[] A){
        // a position P is a peek if: A[P] > A[P-1] && A[P] > A[P+1]
        for(int i = 1; i < A.length - 1; i++){
            if(A[i] > A[i - 1] && A[i] > A[i + 1]) return i;
        }

        return 0;
    }
}
