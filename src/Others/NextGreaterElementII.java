package Others;

/**
 * Created by Lin on 2017/8/21.
 */
public class NextGreaterElementII {
    /**
     * Given a circular array (the next element of the last element is the first element of the array)
     * print the Next Greater Number for every element
     * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array
     * Which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number
     *
     * @see <a href="https://leetcode.com/problems/next-greater-element-ii/">LeetCode</a>
     *
     * @param nums Integer array
     * @return The Next Greater Number for every element
     */
    public int[] nextGreaterElements(int[] nums) {

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            int j = i + 1 == nums.length ? 0 : i + 1;
            while(j != i && nums[j] <= nums[i]) {
                j = j + 1 == nums.length ? 0 : j + 1;
            }

            res[i] = (j == i) ? -1 : nums[j];
        }

        return res;
    }
}
