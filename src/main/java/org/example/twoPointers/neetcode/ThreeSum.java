package org.example.twoPointers.neetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://neetcode.io/problems/three-integer-sum/question?list=neetcode150
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // Sort arrays
        Arrays.sort(nums);
        Set<List<Integer>> lists = new HashSet<>();

        // Select single elements
        for (int i = 0; i < nums.length - 2; i++) {
            int current = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            // look for other elements to complete the triplet
            while (left < right) {
                int sum = current + nums[right] + nums[left];
                if (sum == 0) {
                    lists.add(List.of(current, nums[right], nums[left]));
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists.stream().toList();
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
