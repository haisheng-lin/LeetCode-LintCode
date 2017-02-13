package BinarySearch;

/**
 * Created by Lin on 2017/2/12.
 */
public class WoodCut {
    /**
     * @see <a href="http://www.lintcode.com/en/problem/wood-cut/">LeetCode</a>
     *
     * @param L n pieces of wood with length L[i]
     * @param k An integer
     * @return The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // search maximum number in array
        int max = 0;
        for(int i : L) max = Math.max(max, i);
        // binary search
        int start = 1, end = max;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if(countWood(L, mid) >= k) start = mid;
            else end = mid;
        }
        if(countWood(L, end) >= k) return end;
        else if(countWood(L, start) >= k) return start;

        return 0;
    }

    private int countWood(int[] L, int length){
        int count = 0;
        for(int l : L) count += l / length;
        return count;
    }
}
