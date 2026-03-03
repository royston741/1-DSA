package org.example.algo.twoPointers.leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/description/?envType=problem-list-v2&envId=two-pointers
public class ThreeSumCloset {
    // Input: nums = [-1,2,1,-4], target = 1
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // sort current array
        int closestSum = nums[0] + nums[1] + nums[2]; // temp current sum

        // for every element
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1; // left is next element
            int r = nums.length - 1; // right is end element

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r]; // sum
                // calculate the distance between them abs() method will remove the negative from a number -5 -> 5
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return sum; // sum is exact match
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[]{-1,2,1,-4},1);
    }
}
