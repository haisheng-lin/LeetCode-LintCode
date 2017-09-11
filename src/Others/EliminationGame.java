package Others;

/**
 * Created by Lin on 2017/9/11.
 */
public class EliminationGame {
    /**
     * @see <a href="https://leetcode.com/problems/elimination-game/">LeetCode</a>
     *
     * @param n Integer
     * @return The last number that remains starting with a list of length n
     */
    public int lastRemaining(int n) {

        if(n == 1) return 1;

        int mid = n % 2 == 0 ? (n / 2) : (n / 2 + 1);
        boolean toRight = true;
        int loop = 0;

        while(n != 1) {

            int pos = n % 2 == 0 ? n / 2 : n / 2 + 1;

            if(toRight && pos % 2 == 1) {
                if((n / 2) % 2 == 1) mid += (int) Math.pow(2, loop);
                else mid -= (int) Math.pow(2, loop);
            } else if(!toRight && n % 2 == 0 && pos % 2 == 0) {
                if((n / 2) % 2 == 1) mid += (int) Math.pow(2, loop);
                else mid -= (int) Math.pow(2, loop);
            } else if(!toRight && n % 2 == 1 && pos % 2 == 1) {
                if((n / 2) % 2 == 1) mid += (int) Math.pow(2, loop);
                else mid -= (int) Math.pow(2, loop);
            }

            loop++;
            toRight = !toRight;
            n /= 2;
        }

        return mid;
    }
}
