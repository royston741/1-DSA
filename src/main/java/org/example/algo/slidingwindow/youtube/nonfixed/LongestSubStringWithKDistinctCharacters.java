package org.example.algo.slidingwindow.youtube.nonfixed;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctCharacters {
    public static void main(String[] args) {
        String[] arr = {"t", "h", "i", "s", "i", "s", "a", "l", "o", "n", "g", "x"};
        int k = 4;

        int longest = getLongest(arr, k);

        System.out.println(longest);
    }

    private static int getLongest(String[] arr, int k) {
        int left = 0;
        int longest = 0;
        Map<String, Integer> freqMap = new HashMap<>();

        // loop over every element
        for (int right = 0; right < arr.length; right++) {
            // add it in map if already added increment the frequency
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);

            // if the size greater than allowed distinct character i.e k
            while (freqMap.size() > k) {
                // remove the left element
                int freq = freqMap.get(arr[left]) - 1;
                freqMap.put(arr[left], freq);
                // if the frequency of left element is 0 than remove it from the map
                if (freq == 0)
                    freqMap.remove(arr[left]);
                left++; // move the left pointer
            }
            // calculate the length
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
