package org.example.algo.slidingwindow.neetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        String result = "";
        if (t.length() > s.length())
            return result;

        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray())
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);

        int left = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (tMap.containsKey(rightChar))
                sMap.put(rightChar, sMap.getOrDefault(rightChar, 0) + 1);

            while (tMap.equals(sMap)) {
                result = s.substring(left, right + 1);
                char leftChar = s.charAt(left);
                if (sMap.containsKey(leftChar))
                    sMap.put(leftChar, sMap.get(leftChar) - 1);
                if (sMap.get(leftChar) == 0)
                    sMap.remove(leftChar);
                left++;
            }
        }
        return result;
    }
}
