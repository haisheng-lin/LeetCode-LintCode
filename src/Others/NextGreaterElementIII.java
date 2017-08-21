package Others;

/**
 * Created by Lin on 2017/8/21.
 */
public class NextGreaterElementIII {
    /**
     * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n
     * If no such positive 32-bit integer exists, you need to return -1
     *
     * @see <a href="https://leetcode.com/problems/next-greater-element-iii/">LeetCode</a>
     *
     * @param n Positive integer
     * @return Next greater element or -1 if no next greater element exists
     */
    public int nextGreaterElement(int n) {

        // next permutation
        String str = String.valueOf(n);
        int[] nums = new int[str.length()];
        for(int i = 0; i < nums.length; i++) nums[i] = str.charAt(i) - 48;

        int p1 = nums.length - 1;
        while(p1 > 0 && nums[p1] <= nums[p1 - 1]) p1--;

        if(p1 > 0) {
            int p2 = nums.length - 1;
            while(p2 >= p1 && nums[p1 - 1] >= nums[p2]) p2--;
            swap(nums, p1 - 1, p2);

            int start = p1, end = nums.length - 1;
            while(start < end) swap(nums, start++, end--);
        }

        if(!checkOverflow(nums)) return -1;

        int res = 0;
        for(int i = 0; i < nums.length; i++) res = 10 * res + nums[i];

        return (res == n) ? - 1 : res;
    }

    private boolean checkOverflow(int[] nums) {

        int num = 0;
        for(int i = 0; i < nums.length; i++) {
            int check = 10 * num + nums[i];
            if(num != (check - nums[i]) / 10) return false;
            num = check;
        }

        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
