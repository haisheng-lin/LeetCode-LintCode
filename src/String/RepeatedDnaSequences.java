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
     * @see <a href="https://leetcode.com/problems/repeated-dna-sequences">LeetCode</a>
     *
     * @param s String, DNA sequence.
     * @return List, all repeated 10-letter long DNA sequences.
     */
    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for(int i = 0; i <= s.length() - 10; i++){
            String dna = s.substring(i, i + 10);
            if(!seen.add(dna)) repeated.add(dna);
        }

        return new ArrayList<>(repeated);
    }
}
