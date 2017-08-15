package Array;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Created by Lin on 2017/8/14.
 */
public class FindKPairsWithSmallestSums {
    /**
     * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
     *
     * @see <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/">LeetCode</a>
     *
     * @param nums1 A sorted array
     * @param nums2 A sorted array
     * @param k An integer
     * @return k pairs whose sum is smallest
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // corner case
        if(nums1.length == 0 || nums2.length == 0 || k <= 0) return new ArrayList<>();

        List<int[]> res = new ArrayList<>();
        Queue<Tuble> pq = new PriorityQueue<>(new Comparator<Tuble>(){
            @Override
            public int compare(Tuble o1, Tuble o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0; i < nums2.length; i++) pq.offer(new Tuble(0, i, nums1[0] + nums2[i]));
        while(k -- > 0 && !pq.isEmpty()) {

            Tuble tuble = pq.poll();
            int[] nums = {nums1[tuble.x], nums2[tuble.y]};
            res.add(nums);

            if(tuble.x == nums1.length - 1) continue;
            pq.offer(new Tuble(tuble.x + 1, tuble.y, nums1[tuble.x + 1] + nums2[tuble.y]));
        }

        return res;
    }

    public class Tuble {
        int x, y, val;
        public Tuble(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
