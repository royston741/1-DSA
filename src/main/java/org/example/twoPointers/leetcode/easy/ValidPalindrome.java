package org.example.twoPointers.leetcode.easy;

import java.util.stream.Collectors;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // only alphanumeric element with lower case
        String collect = s.chars().filter(value -> (value >= 'A' && value <= 'Z')
                        || (value >= 'a' && value <= 'z')
                        || (value >= '0' && value <= '9'))
                .mapToObj(value -> (char) value)
                .map(Object::toString)
                .map(String::toLowerCase)
                .collect(Collectors.joining(""));
        // using string buider
        return new StringBuilder(collect).reverse().toString().equals(collect);
    }

    public boolean isPalindrome2(String s) {
        String collect = s.chars().filter(value -> (value >= 'A' && value <= 'Z')
                        || (value >= 'a' && value <= 'z')
                        || (value >= '0' && value <= '9'))
                .mapToObj(value -> (char) value)
                .map(Object::toString)
                .map(String::toLowerCase)
                .collect(Collectors.joining(""));

        int l = 0;
        int r = collect.length() - 1;
        // start from sart and end bring them together to check if it is palindrome
        while (l < r) {
            if (collect.charAt(l) != collect.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
