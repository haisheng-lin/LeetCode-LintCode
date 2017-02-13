package Array;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/2/12.
 */
public class TwoSum {
    /**
     * @see <a href="https://leetcode.com/problems/two-sum/">LeetCode</a>
     *
     * @param nums An array of Integer
     * @param target target = numbers[index1] + numbers[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                break;
            }
            map.put(target - nums[i], i);
        }

        return res;
    }
}
