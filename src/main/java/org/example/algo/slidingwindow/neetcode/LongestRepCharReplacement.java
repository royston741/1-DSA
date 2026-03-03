package org.example.algo.slidingwindow.neetcode;

import java.util.HashMap;
import java.util.Map;

// https://neetcode.io/problems/longest-repeating-substring-with-replacement/question
public class LongestRepCharReplacement {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int longest = 0;
        // loop over every element
        for (int right = 0; right < s.length(); right++) {
            // calculate the freq of every char and add it in frq map
            char currentChar = s.charAt(right);
            int updatedFreq = freqMap.getOrDefault(currentChar, 0) + 1;
            freqMap.put(currentChar, updatedFreq);
            // update the max freq
            maxFreq = Math.max(maxFreq, updatedFreq);

            // need to shrink the window if the character need to be changed is greater than k
            // eg A is the maxFreq 3 , B has freq 2 and k = 1
            // windowSize = 5 | charChange = 5-3=2 i.e. > 1
            int windowSize = right - left + 1;
            int char_need_to_be_changed = windowSize - maxFreq;

            while (char_need_to_be_changed > k) {
                // move the left char
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.getOrDefault(leftChar, 0) - 1);
                left++;
                // update the char need to be changed
                windowSize = right - left + 1;
                char_need_to_be_changed = windowSize - maxFreq;
            }
            // cal calculate longest
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
