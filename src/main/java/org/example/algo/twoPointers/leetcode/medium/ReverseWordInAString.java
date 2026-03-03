package org.example.algo.twoPointers.leetcode.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

// https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=problem-list-v2&envId=two-pointers
public class ReverseWordInAString {

    public static String reverseWords(String s) {
        String[] split = s.split(" ");

        // point at first element and last element
        int left = 0;
        int right = split.length - 1;

        // bright the left and right towards center and replace
        while (left < right) {
            String temp = split[left];
            split[left] = split[right];
            split[right] = temp;
            left++;
            right--;
        }
        return Arrays.stream(split).filter(s1-> !s1.isEmpty()).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        reverseWords("  hello world  ");
    }
}
