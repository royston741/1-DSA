package org.example.algo.slidingwindow.youtube.nonfixed;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChar {
    public static void main(String[] args) {
        String[] arr = {"t", "h", "i", "s", "i", "s", "a", "l", "o", "n", "g", "x"};

        int maxLen = getMaxLen(arr);

        System.out.println(maxLen);

    }

    private static int getMaxLen(String[] arr) {
        int maxLen = 0;
        int left = 0;
        Map<String, Integer> indexMap = new HashMap<>();

        // loop over every element
        for (int right = 0; right < arr.length; right++) {
            // if map contains element that means element is repeated shrink the window
            if (indexMap.containsKey(arr[right])) {
                left = Math.max(indexMap.get(arr[right]) + 1, left); // left can be the next index old index or left only if it is already forward
            }
            // add element to map and calculate length
            indexMap.put(arr[right], right);
            maxLen = Math.max((right - left) + 1, maxLen);
        }
        return maxLen;
    }


}
