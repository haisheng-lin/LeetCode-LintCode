package Array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Lin on 2017/8/14.
 */
public class KthSmallestElementInSortedMatrix {
    /**
     * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
     *
     * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/">LeetCode</a>
     *
     * @param matrix A sorted matrix
     * @param k An integer
     * @return Kth smallest element in matrix
     */
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        Queue<Tuble> pq = new PriorityQueue<>(new Comparator<Tuble>(){
            @Override
            public int compare(Tuble o1, Tuble o2) {
                return o1.val - o2.val;
            }
        });

        for(int r = 0; r < n; r++) pq.offer(new Tuble(r, 0, matrix[r][0]));
        for(int i = 0; i < k - 1; i++) {
            Tuble tuble = pq.poll();
            if(tuble.y == n - 1) continue;
            pq.offer(new Tuble(tuble.x, tuble.y + 1, matrix[tuble.x][tuble.y + 1]));
        }

        return pq.poll().val;
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
