package org.example.algo.slidingwindow.leetcode;

// https://leetcode.com/problems/arithmetic-slices/description/?envType=problem-list-v2&envId=sliding-window
public class ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] nums) {
        int curr = 0;
        int total = 0;
        // loop
        for (int i = 2; i < nums.length; i++) {
            // if previous and previous to previous difference is same
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr++;
                total += curr;
            } else { // else reset the window count
                curr = 0;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        numberOfArithmeticSlices(new int[]{1, 2, 3, 4});

        /*
            1) i = 3
            3-2 == 2-1 i.e 1 == 1
            curr++ = 1 [1,2,3]
            total += curr = 1

            2) i = 4
            4-3 =3-2 i.e 1 == 1
            curr++ = 2 [2,3,4] [1,2,3,4]
            total += curr = 3
        */
    }
}
