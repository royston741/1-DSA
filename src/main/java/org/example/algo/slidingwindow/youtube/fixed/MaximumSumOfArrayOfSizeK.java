package org.example.algo.slidingwindow.youtube.fixed;

public class MaximumSumOfArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, 4, 3, 8, -1, 0, 9};
        int k = 4;

        maximum(k, arr);

        maximum2(k, arr);
    }


    private static void maximum2(int k, int[] arr) {
        int max = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            // add element from window
            total += arr[i];
            // remove element from window
            if (i >= k)
                total -= arr[i - k];
            // for every window update max
            if (i >= k - 1)
                max = Math.max(max, total);
        }
        System.out.println(max);
    }

    private static void maximum(int k, int[] arr) {
        // calculate the first k sum
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        // track the current sun
        int currentSum = maxSum;
        for (int i = k; i < arr.length; i++) {
            // add nex element and remove previous
            currentSum += arr[i];
            currentSum -= arr[i - k];
            // check the max sum
            maxSum = Math.max(currentSum, maxSum);
        }
        System.out.println(maxSum);
    }
}
