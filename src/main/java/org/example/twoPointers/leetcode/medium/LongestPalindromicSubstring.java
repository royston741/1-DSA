package org.example.twoPointers.leetcode.medium;

// https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=two-pointers
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        String longest = "";

        // loop every element
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            // odd length palindrome ---> aba
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                String palindrome = s.substring(left, right + 1);
                if (palindrome.length() > longest.length()) {
                    longest = palindrome;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            // even length palindrome ---> abbab
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {

                String palindrome = s.substring(left, right + 1);
                if (palindrome.length() > longest.length()) {
                    longest = palindrome;
                }
                left--;
                right++;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = longestPalindrome("aa");

        System.out.println(s);
    }
}
