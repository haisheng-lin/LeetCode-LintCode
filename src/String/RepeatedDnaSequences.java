package String;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by Lin on 2017/2/27.
 */
public class RepeatedDnaSequences {
    /**
     * Find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
     *
     * @see <a href="https://leetcode.com/problems/repeated-dna-sequences/?tab=Description">LeetCode</a>
     *
     * @param s String, DNA sequence.
     * @return List, all repeated 10-letter long DNA sequences.
     */
    public List<String> findRepeatedDnaSequences(String s) {
        // create empty list as return result
        List<String> list;
        // HashSet to store seen string, and repeated string
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for(int i = 0; i + 9 < s.length(); i++){
            // create 10-letter long substring
            String str = s.substring(i, i + 10);
            // add into repeated if it is seen before
            if(!seen.add(str)) repeated.add(str);
        }
        // initialize the list with repeated set
        list = new ArrayList<>(repeated);
        // return result
        return list;
    }
}
