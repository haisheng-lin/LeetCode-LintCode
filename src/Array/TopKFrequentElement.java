package Array;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Lin on 2017/8/9.
 */
public class TopKFrequentElement {
    /**
     * Given a non-empty array of integers, return the k most frequent elements.
     * You may assume k is always valid, 1 <= k <= number of unique elements.
     *
     * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/">LeetCode</a>
     *
     * @param nums An integer array
     * @param k An integer
     * @return The k most frequent elements.
     */
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for(int num: frequencyMap.keySet()){
            int frequency = frequencyMap.get(num);
            if(buckets[frequency] == null) buckets[frequency] = new ArrayList<>();
            buckets[frequency].add(num);
        }

        for(int pos = buckets.length - 1; pos >= 0 && res.size() < k; pos--){
            if(buckets[pos] != null) res.addAll(buckets[pos]);
        }

        return res;
    }
}
