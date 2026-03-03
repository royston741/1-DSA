package org.example.algo.slidingwindow.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate-ii/description/?envType=problem-list-v2&envId=sliding-window
public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        //track th elements in window
        Set<Integer> set = new HashSet<>();
        for (int right = 0; right < nums.length; right++) {
            // shrink window if greater thank k
            while (right - left > k) {
                set.remove(nums[left]);
                left++;
            }
            //if already exist in window shrink
            if(!set.add(nums[right])){
                return true;
            }else {
                set.add(nums[left]);
            }
        }
        return false;
    }
}
