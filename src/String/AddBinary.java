package String;

/**
 * Created by Lin on 2017/6/29.
 */
public class AddBinary {

    /***************************************** Best Version *****************************************/

    /**
     * Given two binary strings, return their sum (also a binary string).
     *
     * @see <a href="https://leetcode.com/problems/add-binary/#/description">LeetCode</a>
     *
     * @param a String representing an integer
     * @param b String representing an integer
     * @return String representing sum of a and b
     */
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int ap = a.length() - 1, bp = b.length() - 1;
        int c = 0;

        while(ap >= 0 || bp >= 0 || c == 1){
            c += ap >= 0 ? a.charAt(ap--) - '0' : 0;
            c += bp >= 0 ? b.charAt(bp--) - '0' : 0;
            sb.insert(0, (char)(c % 2 + '0'));
            c /= 2;
        }

        return sb.toString();
    }

    /***************************************** My Version *****************************************/

    /**
     * Given two binary strings, return their sum (also a binary string).
     *
     * @see <a href="https://leetcode.com/problems/add-binary/#/description">LeetCode</a>
     *
     * @param a String representing an integer
     * @param b String representing an integer
     * @return String representing sum of a and b
     */
    public String addBinary2(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int ap = a.length() - 1, bp = b.length() - 1;
        boolean add = false;

        while(ap >= 0 || bp >= 0){

            int aNum = 0, bNum = 0;
            if(ap >= 0) aNum = a.charAt(ap--) - '0';
            if(bp >= 0) bNum = b.charAt(bp--) - '0';

            if(add){
                if(aNum + bNum >= 1) sb.insert(0,String.valueOf(aNum + bNum - 1));
                else{
                    sb.insert(0, '1');
                    add = false;
                }
            }

            else{
                if(aNum + bNum > 1){
                    sb.insert(0, '0');
                    add = true;
                }
                else sb.insert(0, String.valueOf(aNum + bNum));
            }
        }

        if(add) sb.insert(0, '1');

        return sb.toString();
    }
}
