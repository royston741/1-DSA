package org.example.algo.slidingwindow.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAtLeastKRepeatingChar {
    public static int longestSubstring(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : freqMap.keySet()) {
            if (freqMap.get(ch) < k) {
                int max = 0;
                for (String part : s.split(String.valueOf(ch))) {
                    max = Math.max(max, longestSubstring(part, k));
                }
                return max;
            }
        }

        return s.length();
    }

    public static void main(String[] args) {
        longestSubstring("ababacb", 3);
    }
}
