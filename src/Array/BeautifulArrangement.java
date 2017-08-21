package Array;

/**
 * Created by Lin on 2017/8/21.
 */
public class BeautifulArrangement {

    int count = 0;

    /**
     * Suppose you have N integers from 1 to N
     * We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
     * (1) The number at the ith position is divisible by i
     * (2) i is divisible by the number at the ith position
     *
     * @see <a href="https://leetcode.com/problems/beautiful-arrangement/">LeetCode</a>
     *
     * @param N Integer
     * @return Number of beautiful arrangements
     */
    public int countArrangement(int N) {
        boolean[] used = new boolean[N];
        search(used, 0, N);
        return count;
    }

    private void search(boolean used[], int depth, int N){

        if(depth == used.length){
            count++;
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!used[i - 1] && ((depth + 1) % i == 0 || i % (depth + 1) == 0)){
                used[i - 1] = true;
                search(used, depth + 1, N);
                used[i - 1] = false;
            }
        }
    }
}
