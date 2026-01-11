package org.example.twoPointers.leetcode.easy;

import java.util.LinkedHashSet;
import java.util.Set;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=problem-list-v2&envId=two-pointers
public class RemoveDuplicateFromSortedArray {
    //  [0,0,1,1,1,2,2,3,3,4]
    public int removeDuplicates(int[] nums) {
        int l = 0; // left pointer
        // right pointer
        for (int r = 1; r < nums.length; r++) {
            // when we find a different element
            if (nums[r] != nums[l]) {
                l++; // move left pointer
                nums[l] = nums[r]; // update the value at left pointer
            }
        }
        return l + 1;
    }

    private static int removeDuplicate(int[] nums) {
        // Using LinkedHashSet to maintain the order of elements
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num); // Duplicates will be ignored
        }

        int index = 0;
        // Copying unique elements back to the original array
        for (Integer num : set) {
            nums[index++] = num;
        }
        // Returning the count of unique elements
        return set.size();
    }
}
