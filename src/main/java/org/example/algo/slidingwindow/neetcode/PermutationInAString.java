package org.example.algo.slidingwindow.neetcode;

import java.util.HashMap;
import java.util.Map;

// https://neetcode.io/problems/permutation-string/question
public class PermutationInAString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // first add all the character of s1 with their frequency in a map
        Map<Character, Integer> s1Map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        int windowSize = s1.length();
        Map<Character, Integer> s2Map = new HashMap<>();

        // loop over every element of s2
        for (int i = 0; i < s2.length(); i++) {
            // add element in a map
            char rightChar = s2.charAt(i);
            s2Map.put(rightChar, s2Map.getOrDefault(rightChar, 0) + 1);

            // if the window size is grater than s1 length remove left character
            if (i >= windowSize) {
                char leftChar = s2.charAt(i - windowSize);
                s2Map.put(leftChar, s2Map.getOrDefault(leftChar, 0) - 1);
                if (s2Map.get(leftChar) == 0)
                    s2Map.remove(leftChar);
            }

            // check the window is valid
            if (s1Map.equals(s2Map))
                return true;
        }

        return false;
    }
}
