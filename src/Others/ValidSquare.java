package Others;

/**
 * Created by Lin on 2017/8/29.
 */
public class ValidSquare {
    /**
     * Given the coordinates of four points in 2D space, return whether the four points could construct a square
     * The coordinate (x,y) of a point is represented by an integer array with two integers
     *
     * @see <a href="https://leetcode.com/problems/valid-square/">LeetCode</a>
     *
     * @param p1 Integer array
     * @param p2 Integer array
     * @param p3 Integer array
     * @param p4 Integer array
     * @return True if four points could construct a square, else false
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        if(p1[0] == p2[0] && p1[0] == p3[0] && p1[0] == p4[0] && p1[1] == p2[1] && p1[1] == p3[1] && p1[1] == p4[1]) return false;

        boolean res1 = check(p1, p2, p3, p4);
        boolean res2 = check(p1, p3, p2, p4);
        boolean res3 = check(p1, p2, p4, p3);
        boolean res4 = check(p1, p4, p2, p3);
        boolean res5 = check(p1, p3, p4, p2);
        boolean res6 = check(p1, p4, p3, p2);

        return res1 || res2 || res3 || res4 || res5 || res6;
    }

    private boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {

        int x1 = p1[0], y1 = p1[1];
        int x2 = p2[0], y2 = p2[1];
        int x3 = p3[0], y3 = p3[1];
        int x4 = p4[0], y4 = p4[1];

        int l1 = (x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1);
        int l2 = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        int l3 = (x4 - x2) * (x4 - x2) + (y4 - y2) * (y4 - y2);
        int l4 = (x4 - x3) * (x4 - x3) + (y4 - y3) * (y4 - y3);

        if(l1 != l2 || l1 != l3 || l1 != l4) return false;

        int[] v1 = {x3 - x1, y3 - y1};
        int[] v2 = {x2 - x1, y2 - y1};
        int[] v3 = {x3 - x4, y3 - y4};
        int[] v4 = {x2 - x4, y2 - y4};

        int num1 = v1[0] * v2[0] + v1[1] * v2[1];
        int num2 = v3[0] * v4[0] + v3[1] * v4[1];

        return num1 == 0 && num2 == 0;
    }
}
