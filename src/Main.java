import String.CompareVersion;

/**
 * Created by Lin on 2017/2/12.
 */
public class Main {
    public static void main(String[] args){
//        int capacity = 2;
//        LRUCache cache = new LRUCache(capacity);
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4

        String v1 = "13.3.7";
        String v2 = "12.0";

        CompareVersion obj = new CompareVersion();
        obj.compareVersion(v1, v2);
    }
}
