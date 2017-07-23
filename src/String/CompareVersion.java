package String;

/**
 * Created by Lin on 2017/7/17.
 */
public class CompareVersion {
    /**
     * Compare two version numbers version1 and version2.
     * You may assume that the version strings are non-empty and contain only digits and the . character.
     *
     * @see <a href="https://leetcode.com/problems/compare-version-numbers/#/description">LeetCode</a>
     *
     * @param version1 A String
     * @param version2 A String
     * @return If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
     */
    public int compareVersion(String version1, String version2) {

        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int p1 = 0, p2 = 0;

        while(p1 < nums1.length || p2 < nums2.length){

            int num1 = 0, num2 = 0;
            if(p1 < nums1.length) num1 = Integer.valueOf(nums1[p1++]);
            if(p2 < nums2.length) num2 = Integer.valueOf(nums2[p2++]);

            if(num1 > num2) return 1;
            else if(num1 < num2) return -1;
        }

        return 0;
    }
}
