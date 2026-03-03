package org.example.algo.slidingwindow.leetcode;

import java.util.*;

// https://leetcode.com/problems/repeated-dna-sequences/description/?envType=problem-list-v2&envId=sliding-window
public class RepeatedDNASequence {
    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // create a substring
            String substring = s.substring(left, right + 1);
            // if substring greater than 10 than shrink
            while (substring.length() > 10) {
                left++;
                substring = s.substring(left, right + 1);
            }
            // if substring length = 10 than add in map
            if (substring.length() == 10)
                map.put(substring, map.getOrDefault(substring, 0) + 1);
        }
        return map.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).toList();
    }

    public static List<String> findRepeatedDnaSequences2(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }
        return map.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).toList();
    }

    public static void main(String[] args) {
        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
