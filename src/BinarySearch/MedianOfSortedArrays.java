package BinarySearch;

/**
 * Created by Lin on 2017/5/12.
 */
public class MedianOfSortedArrays {
    /**
     * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/#/description">LeetCode</a>
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * @param nums1 A given Integer array
     * @param nums2 A given Integer array
     * @return median of two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        if(len1 > len2){
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int imin = 0, imax = len1, halfLen = (len1 + len2 + 1) / 2;
        while(imin < imax){
            int i = (imin + imax) / 2;
            int j = halfLen - i;
            // i is too large
            if(i > 0 && nums1[i - 1] > nums2[j]){
                imax = i - 1;
            }
            // i is too small
            else if(i < len1 && nums2[j - 1] > nums1[i]){
                imin = i + 1;
            }
            // i is perfect
            else{
                int maxLeft, minRight;

                if(i == 0){
                     maxLeft = nums1[j - 1];
                }
                else if(j == 0){
                    maxLeft = nums2[i - 1];
                }
                else{
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                // if total length is odd
                if((len1 + len2) % 2 == 1) return maxLeft;

                if(i == len1){
                    minRight = nums2[j];
                }
                else if(j == len2){
                    minRight = nums1[i];
                }
                else{
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0;
    }
}
