package Greedy;

import java.util.Stack;

/**
 * Created by Lin on 2017/2/14.
 */
public class LengthLongestPath {
    /**
     * Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system.
     * If there is no file in the system, return 0.
     *
     * @see <a href="https://leetcode.com/problems/longest-absolute-file-path/">LintCode</a>
     *
     * @param input A String
     * @return Length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // result
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        // dummy push
        stack.push(0);
        for(String s : input.split("\n")){
            // number of "\t"
            int lev = s.lastIndexOf("\t") + 1;
            // find parent
            while(lev + 1 < stack.size()) stack.pop();
            // calculate length of current path
            int length = stack.peek() + s.length() - lev + 1; // remove "\t" and add "/"
            stack.push(length);
            // check if the path is a file
            if(s.contains(".")) max = Math.max(max, length - 1); // "length - 1" means remove the last "/"
        }
        // return result
        return max;
    }
}
