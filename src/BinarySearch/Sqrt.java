package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class Sqrt {
    /**
     * @see <a href="https://leetcode.com/problems/sqrtx/">LeetCode</a>
     *
     * @param x an integer
     * @return the sqrt of x
     */
    public int sqrt(int x) {
        // corner case
        if(x == 0) return 0;

        int start = 0, end = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            else if(mid < x / mid) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
}
