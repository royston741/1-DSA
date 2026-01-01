package org.example.twoPointers.neetcode;

import java.util.HashMap;
import java.util.Map;

// https://neetcode.io/problems/two-integer-sum-ii/question?list=neetcode150
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        // The array is sorted in non-decreasing order. Left pointer points to the smallest number,
        // right pointer points to the largest number.
        int left = 0;
        int right = numbers.length - 1;

        // Move until the two pointers meet.
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // Check if the sum of the two numbers is equal to the target.
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) { // If the sum is too large, move the right pointer to the left.
                right--;
            } else { // If the sum is too small, move the left pointer to the right.
                left++;
            }
        }

        return new int[]{};
    }

    public int[] twoSumMapApproach(int[] numbers, int target) {
        // Using a HashMap to store the numbers and their indices.
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            // check if the remainder (target - numbers[i]) exists in the map
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            } else {
                // add the current number and its index to the map
                map.put(numbers[i], i);
            }
        }

        return new int[]{};
    }
}
