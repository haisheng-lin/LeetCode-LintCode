import Recursion.ExpressionAddOperators;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Lin on 2017/2/12.
 */
public class Main {
    public static void main(String[] args){
        int[][] envelopes = {{2,3},{5,4},{6,4},{6,7}};
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[1] - o2[0];
            }
        });
    }
}
