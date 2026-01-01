package org.example.twoPointers.neetcode;

// https://neetcode.io/problems/trapping-rain-water/question?list=neetcode150
public class TrappingRainWater {
    public static int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int rightMax = 0;
        int leftMax = 0;
        int maxWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    maxWater = maxWater + (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    maxWater = maxWater + (rightMax - height[right]);
                }
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        trap(new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1});
    }
}
