package Recursion;

import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;

/**
 * Created by Lin on 2017/7/28.
 */
public class KthLargestElement {

    /***************************************** Quick Select Version *****************************************/

    /**
     * Find the kth largest element in an unsorted array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">LeetCode</a>
     *
     * @param nums An integer array
     * @param k An Integer
     * @return kth largest element in array
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int quickSelect(int[] nums, int start, int end, int k){

        int pivot = nums[start];

        // 把少于等于pivot的元素置于左边，大于pivot的元素置于右边
        int lo = start, hi = end;
        while(lo < hi){
            if(nums[hi--] < pivot) swap(nums, ++lo, ++hi);
        }

        // 把pivot置于它在数组里第lo大的位置
        swap(nums, start, lo);

        // 计算少于等于pivot元素的数量
        int count = lo - start + 1;

        // Case 1: 如果count小于k，那么target必然在lo的右边
        if(count < k) return quickSelect(nums, lo + 1, end, k - count);

        // Case 2:如果count大于k，那么target必然在lo的左边
        else if( count > k) return quickSelect(nums, start, lo - 1, k);

        // Case 3: 如果count等于k，说明这就是我们找的target
        else return nums[lo];
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /***************************************** Priority Queue Version *****************************************/

    /**
     * Find the kth largest element in an unsorted array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">LeetCode</a>
     *
     * @param nums An integer array
     * @param k An Integer
     * @return kth largest element in array
     */
    public int findKthLargest2(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int num: nums) queue.offer(num);
        for(int i = 0; i < k - 1; i++) queue.poll();

        return queue.poll();
    }
}
