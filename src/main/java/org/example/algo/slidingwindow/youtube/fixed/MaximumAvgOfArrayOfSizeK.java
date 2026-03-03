package org.example.algo.slidingwindow.youtube.fixed;

public class MaximumAvgOfArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, 4, 3, 8, -1, 0, 9};
        int k = 4;

        maxAvg(k, arr);
        maxAvg2(k, arr);

    }

    private static void maxAvg2(int k, int[] arr) {
        double max = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            // add element from window
            total += arr[i];
            // remove element from window
            if (i >= k)
                total -= arr[i - k];
            // for every window update max
            if (i >= k - 1)
                max = Math.max(max, (double) total / k);
        }
        System.out.println(max);
    }

    private static void maxAvg(int k, int[] arr) {
        // calculate the first k avg
        int total = 0;
        for (int i = 0; i < k; i++) {
            total += arr[i];
        }

        double maxAvg = (double) total / k;

        // track the current sun
        int currentSum = total;
        for (int i = k; i < arr.length; i++) {
            // add nex element and remove previous
            currentSum += arr[i];
            currentSum -= arr[i - k];
            // check the max sum
            maxAvg = Math.max((double) currentSum / k, maxAvg);
        }
        System.out.println(maxAvg);
    }
}
