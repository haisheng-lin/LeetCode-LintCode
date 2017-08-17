package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lin on 2017/8/17.
 */
public class RelativeRanks {
    /**
     * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
     *
     * @see <a href="https://leetcode.com/problems/relative-ranks/">LeetCode</a>
     *
     * @param nums An integer array representing scores of each athlete
     * @return Relative ranks
     */
    public String[] findRelativeRanks(int[] nums) {

        String[] res = new String[nums.length];
        Map<Integer, Integer> originMap = new HashMap<>();
        Map<Integer, Integer> sortedMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            originMap.put(i, nums[i]);
        }

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            sortedMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {

            int originPos = i;
            int val = originMap.get(originPos);
            int sortedPos = sortedMap.get(val);

            if(sortedPos == nums.length - 1) {
                res[i] = "Gold Medal";
            } else if(sortedPos == nums.length - 2) {
                res[i] = "Silver Medal";
            } else if(sortedPos == nums.length - 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = String.valueOf(nums.length - sortedPos);
            }
        }

        return res;
    }
}
