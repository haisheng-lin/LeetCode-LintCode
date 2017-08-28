package Others;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lin on 2017/8/26.
 */
public class Dota2Senate {
    /**
     * @see <a href="https://leetcode.com/problems/dota2-senate/">LeetCode</a>
     *
     * @param senate String
     * @return "Radiant" if Radiant can win, else return "Dire"
     */
    public String predictPartyVictory(String senate) {

        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        for(int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R') rQueue.offer(i);
            else dQueue.offer(i);
        }

        while(!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll(), d = dQueue.poll();
            if(r < d) rQueue.offer(r + senate.length());
            else dQueue.offer(d + senate.length());
        }

        return dQueue.isEmpty() ? "Radiant" : "Dire";
    }
}
