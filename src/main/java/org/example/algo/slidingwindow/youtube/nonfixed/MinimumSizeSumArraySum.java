package org.example.algo.slidingwindow.youtube.nonfixed;

public class MinimumSizeSumArraySum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int minLen = getMinLen(arr, target);
        System.out.println(minLen);
    }

    private static int getMinLen(int[] arr, int target) {
        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int total = 0;

        // loop element
        for (int right = 0; right < arr.length; right++) {
            total += arr[right]; // sum total
            while (total > target) { // while total > 7 than shrink the window by increment left
                total -= arr[left];
                left++;
            }
            if (total == target)// if target than call min length
                minLen = Math.min(minLen, right - left + 1);
        }
        return minLen;
    }
}
