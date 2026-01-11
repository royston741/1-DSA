package org.example.twoPointers.leetcode.easy;


// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=problem-list-v2&envId=two-pointers
public class FindTheFirstIndexOccur {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);

    }

    public static int strStr2(String haystack, String needle) {
        // if the length of tring to be search is greater than return -1
        if (needle.length() > haystack.length()) return -1;

        // for every index
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            // check if every element of the string is present from the index
            while (j < needle.length() && ((i + j) < haystack.length())) {
                if (needle.charAt(j) == haystack.charAt(i + j)) {
                    j++;
                } else {
                    break;
                }
            }
            // if length matches than return index
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr3(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        // for every element
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String substring = haystack.substring(i, i + needle.length()); // get a substring from index
            if (substring.equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        strStr2("sadbutsad", "sad");
        strStr3("hello","ll");
    }
}
