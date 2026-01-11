package org.example.arrays;

// https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int right = 1; right < nums.length; right++) {
            // current sum will be max of current sum plus element or start with new element
            currentSum = Math.max(currentSum + nums[right], nums[right]);
            maxSum = Math.max(currentSum, maxSum); // update max
        }
        return maxSum;
    }
}
