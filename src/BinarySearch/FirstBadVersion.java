package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class FirstBadVersion {
    /**
     * @see <a href="https://leetcode.com/problems/first-bad-version/">LeetCode</a>
     *
     * @param n An integer
     * @return An integer which is the first bad version
     */
    public int findFirstBadVersion(int n){

        int start = 1, end = n;

        while(start < end){
            int mid = start + (end - start) / 2; // prevent overflow

            if(isBadVersion(mid)) end = mid;
            else start = mid + 1;
        }

        return start;
    }

    public boolean isBadVersion(int k){
        return true;
    }
}
