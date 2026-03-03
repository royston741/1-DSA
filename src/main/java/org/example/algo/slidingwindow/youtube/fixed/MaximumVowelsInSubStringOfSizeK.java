package org.example.algo.slidingwindow.youtube.fixed;

public class MaximumVowelsInSubStringOfSizeK {
    public static void main(String[] args) {
        String[] arr = {"t", "h", "i", "s", "i", "s", "a", "l", "o", "n", "g", "x"};
        int k = 4;

        int maxVowel = getMaxVowel(arr, k);
        System.out.println(maxVowel);

        int maxVowel1 = getMaxVowel1(arr, k);
        System.out.println(maxVowel1);
    }


    private static int getMaxVowel1(String[] arr, int k) {
        String vowel = "aeiou";

        int max = Integer.MIN_VALUE;

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (vowel.contains(arr[i]))
                count++;

            if (i >= k && vowel.contains(arr[i - k]))
                count--;

            if (i >= k - 1)
                max = Math.max(max, count);
        }
        return max;
    }

    private static int getMaxVowel(String[] arr, int k) {
        String vowel = "aeiou";

        int maxVowel = 0;
        int count = 0;

        // loop over every element
        for (int i = 0; i < arr.length; i++) {
            // add element  if vowel increment count
            if (vowel.contains(arr[i]))
                count++;

            // delete element check if vowel decrease count
            if (i >= k && vowel.contains(arr[i - k]))
                count--;

            // calculate max vowel only if the size o substring will become k i.e 54
            if (i >= k - 1)
                maxVowel = Math.max(count, maxVowel);
        }
        return maxVowel;
    }
}
