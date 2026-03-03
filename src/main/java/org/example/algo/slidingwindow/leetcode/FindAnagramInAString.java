package org.example.algo.slidingwindow.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/?envType=problem-list-v2&envId=sliding-window
public class FindAnagramInAString {
    public List<Integer> findAnagrams(String s, String p) {
        // create a map of anagram element and there freq
        Map<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0;
        int windowSize = p.length();
        // for every window check if the same element and their freq is present in pMap
        for (int right = 0; right < s.length(); right++) {
            char charAt = s.charAt(right);
            sMap.put(charAt, sMap.getOrDefault(charAt, 0) + 1);

            // remove the left element if the window size become greater tha anagram string
            while (right - left >= windowSize) {
                char leftChar = s.charAt(left);
                int freq = sMap.get(leftChar) - 1;
                sMap.put(leftChar, freq);
                if (freq == 0)
                    sMap.remove(leftChar);
                left++;
            }

            if (sMap.equals(pMap)) {
                list.add(left);
            }
        }

        return list;
    }
}
