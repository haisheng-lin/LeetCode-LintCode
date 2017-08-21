package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Lin on 2017/8/21.
 */
public class QueueReconstructionByHeight {
    /**
     * Suppose you have a random list of people standing in a queue
     * Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h
     * Write an algorithm to reconstruct the queue.
     *
     * @see <a href="https://leetcode.com/problems/queue-reconstruction-by-height/">LeetCode</a>
     *
     * @param people 2D integer array
     * @return 2D integer array
     */
    public int[][] reconstructQueue(int[][] people) {

        List<int[]> list = new ArrayList<>();

        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });

        for(int[] person: people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
