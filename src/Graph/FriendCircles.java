package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Lin on 2017/8/24.
 */
public class FriendCircles {

    /***************************************** My Version *****************************************/

    int unionNo = 0;

    /**
     * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature
     * We defined a friend circle is a group of students who are direct or indirect friends
     * Given a N*N matrix M representing the friend relationship between students in the class
     * If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not
     * Output the total number of friend circles among all the students
     *
     * @see <a href="https://leetcode.com/problems/friend-circles/">LeetCode</a>
     *
     * @param M 2D integer array
     * @return Number of friend circles
     */
    public int findCircleNum(int[][] M) {

        int num = M.length;
        Map<Integer, Integer> friendMap = new HashMap<>();

        for(int i = 0; i < num; i++) {
            for(int j = i; j < num; j++) {
                if(M[i][j] == 1) buildCircle(friendMap, i, j);
            }
        }

        Set<Integer> unionSet = new HashSet<>();
        for(int student: friendMap.keySet()) unionSet.add(friendMap.get(student));

        return unionSet.size();
    }

    private void buildCircle(Map<Integer, Integer> friendMap, int studentA, int studentB) {

        // 1. 如果两人都没有朋友圈，那么为他们新建朋友圈
        if(!friendMap.containsKey(studentA) && !friendMap.containsKey(studentB)) {
            friendMap.put(studentA, unionNo);
            friendMap.put(studentB, unionNo);
            unionNo++;
        }

        // 2. 如果一人有朋友圈而另一个人没有，那么把他加进朋友圈
        else if(friendMap.containsKey(studentA) && !friendMap.containsKey(studentB)) {
            int union = friendMap.get(studentA);
            friendMap.put(studentB, union);
        }

        else if(!friendMap.containsKey(studentA) && friendMap.containsKey(studentB)) {
            int union = friendMap.get(studentB);
            friendMap.put(studentA, union);
        }

        // 3. 如果两人都有朋友圈，那么把它们融合成一个
        else {
            int u1 = friendMap.get(studentA), u2 = friendMap.get(studentB);
            for(int student: friendMap.keySet()) {
                if(friendMap.get(student) == u2) friendMap.put(student, u1);
            }
        }
    }

    /***************************************** Best Version *****************************************/

    class UnionFind {

        private int count;
        private int[] parent, rank;

        public UnionFind(int n) {

            parent = new int[n];
            rank = new int[n];
            count = n;

            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int p) {

            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }

            return p;
        }

        public void union(int p, int q) {

            int rootP = findParent(p);
            int rootQ = findParent(q);
            if(rootP == rootQ) return;

            if(rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                if(rank[rootP] == rank[rootQ]) rank[rootP]++;
            }

            count--;
        }

        public int count() {
            return count;
        }
    }

    /**
     * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature
     * We defined a friend circle is a group of students who are direct or indirect friends
     * Given a N*N matrix M representing the friend relationship between students in the class
     * If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not
     * Output the total number of friend circles among all the students
     *
     * @see <a href="https://leetcode.com/problems/friend-circles/">LeetCode</a>
     *
     * @param M 2D integer array
     * @return Number of friend circles
     */
    public int findCircleNum2(int[][] M) {

        int n = M.length;
        UnionFind uf = new UnionFind(n);

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(M[i][j] == 1) uf.union(i, j);
            }
        }

        return uf.count();
    }
}
