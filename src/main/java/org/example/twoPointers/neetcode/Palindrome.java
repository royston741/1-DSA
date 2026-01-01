package org.example.twoPointers.neetcode;

import java.util.List;

//https://neetcode.io/problems/is-palindrome/question?list=neetcode150
public class Palindrome {
    public static boolean isPalindrome(String s) {
        // Convert the string to a list of characters, filtering out non-alphanumeric characters
        List<Character> characters = s.chars()
                .mapToObj(value -> (char) value)
                .filter(character -> (character >= 'A' && character <= 'Z')
                                     || (character >= 'a' && character <= 'z')
                                     || (character >= '0' && character <= '9')).toList();

        int left = 0;
        int right = characters.size() - 1;

        // Compare characters from both ends towards the center
        while (left < right) {
            String leftChar = characters.get(left) + "";
            String rightChar = characters.get(right) + "";
            // Case-insensitive comparison of characters
            if (!leftChar.equalsIgnoreCase(rightChar)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome("Was it a car or a cat I saw?");
        System.out.println(palindrome);
    }
}
