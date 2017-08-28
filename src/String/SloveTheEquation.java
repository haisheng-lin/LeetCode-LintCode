package String;

/**
 * Created by Lin on 2017/8/27.
 */
public class SloveTheEquation {
    /**
     * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient
     * If there is no solution for the equation, return "No solution"
     * If there are infinite solutions for the equation, return "Infinite solutions"
     * If there is exactly one solution for the equation, we ensure that the value of x is an integer
     *
     * @see <a href="https://leetcode.com/problems/solve-the-equation/">LeetCode</a>
     *
     * @param equation String
     * @return Value of x in the equation or "No solution", "Infinite solutions"
     */
    public String solveEquation(String equation) {

        int left_num = 0, right_num = 0;
        int left_x = 0, right_x = 0;

        char operator = '+';
        boolean isLeft = true;
        boolean forX = false;
        String strNum = "";

        for(int i = 0; i < equation.length(); i++) {

            char cur = equation.charAt(i);

            // Case 1： 当前是 '='，区分开方程左右部分，结算操作，并重置所有变量
            if(cur == '=') {

                // 结算操作，肯定是左边的
                if(strNum.length() > 0 || forX) {
                    int num = (forX && strNum.length() == 0) ? 1 : Integer.valueOf(strNum);
                    // 结算x系数
                    if(forX) {
                        if(operator == '+') left_x += num;
                        else left_x -= num;
                    }
                    // 结算普通数字
                    else {
                        if(operator == '+' && isLeft) left_num += num;
                        else left_num -= num;
                    }
                }

                operator = '+';
                isLeft = false;
                forX = false;
                strNum = "";
            }

            // Case 2： 当前是操作符
            else if(cur == '+' || cur == '-') {

                // 结算操作
                if(strNum.length() > 0 || forX) {
                    int num = (forX && strNum.length() == 0) ? 1 : Integer.valueOf(strNum);
                    // 结算x系数
                    if(forX) {
                        if(operator == '+' && isLeft) left_x += num;
                        else if(operator == '-' && isLeft) left_x -= num;
                        else if(operator == '+' && !isLeft) right_x += num;
                        else right_x -= num;
                    }
                    // 结算普通数字
                    else {
                        if(operator == '+' && isLeft) left_num += num;
                        else if(operator == '-' && isLeft) left_num -= num;
                        else if(operator == '+' && !isLeft) right_num += num;
                        else right_num -= num;
                    }
                }

                strNum = "";
                forX = false;
                operator = cur;
            }

            // Case 3： 当前是 'x'
            else if(cur == 'x'){

                forX = true;

                // 最后一位则需要结算操作，肯定是右边
                if(i == equation.length() - 1) {
                    if(strNum.length() > 0 || forX) {
                        int num = (forX && strNum.length() == 0) ? 1 : Integer.valueOf(strNum);
                        // 结算x系数
                        if(forX) {
                            if(operator == '+') right_x += num;
                            else right_x -= num;
                        }
                        // 结算普通数字
                        else {
                            if(operator == '+') right_num += num;
                            else right_num -= num;
                        }
                    }
                }

            }

            // Case 4： 当前是数字
            else {

                strNum += cur;

                // 最后一位则需要结算操作，肯定是右边
                if(i == equation.length() - 1) {
                    if(strNum.length() > 0 || forX) {
                        int num = (forX && strNum.length() == 0) ? 1 : Integer.valueOf(strNum);
                        // 结算x系数
                        if(forX) {
                            if(operator == '+') right_x += num;
                            else right_x -= num;
                        }
                        // 结算普通数字
                        else {
                            if(operator == '+') right_num += num;
                            else right_num -= num;
                        }
                    }
                }
            }
        }

        if(left_x == right_x && left_num == right_num) return "Infinite solutions";
        else if(left_x == right_x && left_num != right_num) return "No solution";
        else return String.valueOf("x=" + (right_num - left_num) / (left_x - right_x));
    }
}
