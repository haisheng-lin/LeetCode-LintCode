import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lin on 2017/2/12.
 */
public class Main {
    public static void main(String[] args){
        List<Integer> test = new ArrayList<>();
        test.add(3);
        test.add(3);
        test.add(4);
        test.add(7);
        test.add(7);
        findClosestElements(test, 3, 5);
    }

    public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {

        // corner case
        if(arr == null || arr.isEmpty()) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        int pos = binarySearch(arr, x);
        if(pos >= arr.size()){
            for(int i = arr.size() - k; i < arr.size(); i++) res.add(arr.get(i));
        } else {
            int left = pos, right = pos + 1;
            while(k-- > 0){
                if(left < 0){
                    res.add(arr.get(right++));
                } else if(right >= arr.size()){
                    res.add(arr.get(left--));
                } else {

                    int num1 = Math.abs(arr.get(left) - x);
                    int num2 = Math.abs(arr.get(right) - x);

                    if(num1 <= num2) res.add(arr.get(left--));
                    else res.add(arr.get(right++));
                }
            }
        }

        Collections.sort(res);

        return res;
    }

    private static int binarySearch(List<Integer> arr, int x){

        int start = 0, end = arr.size() - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr.get(mid) < x) start = mid + 1;
            else if(arr.get(mid) > x) end = mid;
            else return mid;
        }

        return (start < arr.size() && x < arr.get(start)) ? start : start + 1;
    }
}
