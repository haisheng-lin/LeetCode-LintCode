package Others;

/**
 * Created by Lin on 2017/9/11.
 */
public class TeemoAttacking {
    /**
     * Given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking
     * You need to output the total time that Ashe is in poisoned condition
     *
     * @see <a href="https://leetcode.com/problems/teemo-attacking/">LeetCode</a>
     *
     * @param timeSeries Integer array
     * @param duration Integer
     * @return Total time that Ashe is in poisoned condition
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int res = 0;

        for(int i = 0; i < timeSeries.length; i++) {
            if(i < timeSeries.length - 1 && timeSeries[i] + duration >= timeSeries[i + 1]) res += timeSeries[i + 1] - timeSeries[i];
            else res += duration;
        }

        return res;
    }
}
