package org.example.twoPointers.leetcode;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int l = 0;
        int r = 1;
        String res = "";

        while (r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                r++;
            } else {
                String sub = s.substring(l, r+1);
                boolean equals = new StringBuilder(sub).reverse().toString().equals(sub);
                if (equals && sub.length() > res.length())
                    res = sub;
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = longestPalindrome("cbbd");
        System.out.println(s);
    }
}
