package org.example.twoPointers.leetcode.easy;

// https://leetcode.com/problems/remove-element/description/?envType=problem-list-v2&envId=two-pointers
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        // Trying to mve the index forward if the value match but does not work
        // [0,1,2,2,3,0,4,2], val = 2 ---> if i found 2 first and next to move it foward than also 2 exist
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == val) {
//                count++;
//                for (int j = i; j < nums.length - 1; j++) {
//                    nums[j] = nums[j + 1];
//                }
//            }
//        }
//        return count;

        int l = 0; // left pointer to track position to insert
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != val) { // if the element is not val
                nums[l] = nums[r]; // replace with the position to insert
                l++; // move the left pointer
            }
        }
        return l;
    }

    public static void main(String[] args) {
        removeElement(new int[]{3, 2, 2, 3}, 3);
    }
}
