package Array;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lin on 2017/7/30.
 */
public class SummaryRanges {
    /**
     * @see <a href="https://leetcode.com/problems/summary-ranges/">LeetCode</a>
     *
     * @param nums List of integers
     * @return The summary of array ranges
     */
    public List<String> summaryRanges(int[] nums) {

        // corner case
        if(nums == null || nums.length == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        int start = nums[0], end = nums[0];
        int pre = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == pre + 1) {
                end = nums[i];
                pre = nums[i];
            } else {
                String range = (start == end) ? String.valueOf(start) : String.valueOf(start) + "->" + String.valueOf(end);
                res.add(range);
                start = nums[i];
                end = nums[i];
                pre = nums[i];
            }
        }

        String range = (start == end) ? String.valueOf(start) : String.valueOf(start) + "->" + String.valueOf(end);
        res.add(range);

        return res;
    }
}
