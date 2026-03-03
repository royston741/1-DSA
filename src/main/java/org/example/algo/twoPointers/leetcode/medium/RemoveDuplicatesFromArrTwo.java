package org.example.algo.twoPointers.leetcode.medium;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=problem-list-v2&envId=two-pointers
public class RemoveDuplicatesFromArrTwo {
    public int removeDuplicates(int[] nums) {
        int l = 1;
        int count = 1; // count the frequency of repeated element
        // loop over every element
        for (int r = 1; r < nums.length; r++) {
            // check if prev element is similar
            if (nums[r] == nums[r - 1]) {
                count++;// increment if similar
            } else {
                count = 1; // reset
            }
            // until the element is not more than to update the left and increment left
            if (count <= 2) {
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}
