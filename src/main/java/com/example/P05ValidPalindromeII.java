package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05ValidPalindromeII {
    /*
     * Mindmap
     * ValidPalindromeII
     * - Inputs
     *   - string s
     * - Goal
     *   - check if can be palindrome after <= 1 deletion
     * - Strategy
     *   - two pointers
     *   - on mismatch, skip left or right once
     * - Output
     *   - true/false
     * - Complexity
     *   - time: O(n)
     *   - space: O(1)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string:");
        String s = reader.readLine();
        System.out.println(validPalindrome(s));
    }

    static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindromeRange(s, left + 1, right) || isPalindromeRange(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindromeRange(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

