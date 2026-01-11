package org.example.arrays;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {

    // [1,2,3,4]
    public int[] productExceptSelf(int[] nums) {
        // suffix will hold product of all the element before it
        int[] suffix = new int[nums.length];
        // prefix will hold product of all the element after it
        int[] prefix = new int[nums.length];

        prefix[0] = 1; // suffix[0] is 1 because it has no element before it
        // start with element at 1 index
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }  // suffix = [1,1,2,6]

        //prefix[lastIndex] is 1 because there is no element after it
        suffix[suffix.length - 1] = 1;
        // start with 2nd last index
        for (int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        } // prefix = [24, 12, 4, 1]

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = suffix[i] * prefix[i];
        }

        return result; // [24, 12, 8, 6]
    }
}
