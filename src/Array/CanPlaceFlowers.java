package Array;

/**
 * Created by Lin on 2017/8/20.
 */
public class CanPlaceFlowers {
    /**
     * Suppose you have a long flowerbed in which some of the plots are planted and some are not
     * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die
     * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n
     * Return if n new flowers can be planted in it without violating the no-adjacent-flowers rule
     *
     * @see <a href="https://leetcode.com/problems/contains-duplicate/">LeetCode</a>
     *
     * @param flowerbed An integer array
     * @param n Integer representing number of flowers to be placed
     * @return True if flowerbed can place the n flowers without violating non-adjacent rule, else false
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for(int i = 0; i < flowerbed.length && n > 0;) {

            // search next available plot
            while(i < flowerbed.length && flowerbed[i] == 1) i++;
            if(i == flowerbed.length) break;

            // check adjacent plot
            boolean canPlace = true;
            if(i - 1 >= 0 && flowerbed[i - 1] == 1) canPlace = false;
            if(i + 1 < flowerbed.length && flowerbed[i + 1] == 1) canPlace = false;

            if(canPlace) {
                n--;
                flowerbed[i] = 1;
            }

            i++;
        }

        return n == 0;
    }
}
