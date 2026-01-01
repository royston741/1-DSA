package org.example.twoPointers.neetcode;

// https://neetcode.io/problems/max-water-container/question?list=neetcode150
public class ContainerWithMostWater {
    public int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            // select min height and calculate area
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(area, maxArea);
            // move the pointer if the height is less
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
