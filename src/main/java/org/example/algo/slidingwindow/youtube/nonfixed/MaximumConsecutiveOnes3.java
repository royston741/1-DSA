package org.example.algo.slidingwindow.youtube.nonfixed;

public class MaximumConsecutiveOnes3 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int maxLen = getMaxLen(arr, k);

        System.out.println(maxLen);
    }



    private static int getMaxLen(int[] arr, int k) {
        int zeroes = 0;
        int left = 0;
        int maxLen = 0;

        //loop for every element
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) // if element is 0 increment
                zeroes++;

            // if zeroes greater than k shrink the window and zeroes found decrement count
            while (zeroes > k) {
                if (arr[left] == 0)
                    zeroes--;
                left++;
            }
            // cal max len
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
