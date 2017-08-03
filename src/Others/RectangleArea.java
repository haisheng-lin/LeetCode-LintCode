package Others;

/**
 * Created by Lin on 2017/7/30.
 */
public class RectangleArea {
    /**
     * Find the total area covered by two rectilinear rectangles in a 2D plane.
     * Each rectangle is defined by its bottom left corner and top right corner.
     *
     * @see <a href="https://leetcode.com/problems/rectangle-area">LeetCode</a>
     *
     * @param A X-Axis value of bottom left corner in rectangle ABCD
     * @param B Y-Axis value of bottom left corner in rectangle ABCD
     * @param C X-Axis value of top right corner in rectangle ABCD
     * @param D Y-Axis value of top right corner in rectangle ABCD
     * @param E X-Axis value of bottom left corner in rectangle EFGH
     * @param F Y-Axis value of bottom left corner in rectangle EFGH
     * @param G X-Axis value of top right corner in rectangle EFGH
     * @param H Y-Axis value of top right corner in rectangle EFGH
     * @return Total area covered by two rectangles
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int area1 = (C - A) * (D - B); // 矩形ABCD的面积
        int area2 = (G - E) * (H - F); // 矩形EFGH的面积

        // Case 1：两个矩形相离
        if(A >= G || C <= E || D <= F || B >= H) return area1 + area2;

        // Case 2：ABCD包含EFGH
        else if(A <= E && G <= C && B <= F && H <= D) return area1;

        // Case 3：EFGH包含ABCD
        else if(E <= A && C <= G && F <= B && D <= H) return area2;

        // Case 4：两个矩形相交
        else{
            int bottom_left_x = (A <= E && E <= C) ? E : A;
            int bottom_left_y = (B <= F && F <= D) ? F : B;
            int top_right_x = (A <= G && G <= C) ? G : C;
            int top_right_y = (B <= H && H <= D) ? H : D;

            int repeat = (top_right_x - bottom_left_x) * (top_right_y - bottom_left_y);

            return area1 + area2 - repeat;
        }
    }
}
