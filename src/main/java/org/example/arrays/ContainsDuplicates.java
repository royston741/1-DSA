package org.example.arrays;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //Add all the elements
        for (int num : nums) {
            // if the element is already present than return true
            if (!set.add(num)) {
                return true;
            }
        }
        return false; // no duplicates found
    }

    public boolean containsDuplicate2(int[] nums) {
        // Add all element to set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // if size does not match than duplicates
        return !(nums.length == set.size());
    }
}
