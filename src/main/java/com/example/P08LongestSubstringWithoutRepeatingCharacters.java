package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P08LongestSubstringWithoutRepeatingCharacters {
    /*
     * Mindmap
     * LongestSubstringWithoutRepeatingCharacters
     * - Inputs
     *   - string s
     * - Goal
     *   - longest substring without repeats
     * - Strategy
     *   - sliding window
     *   - map char -> last index
     * - Output
     *   - length
     * - Complexity
     *   - time: O(n)
     *   - space: O(min(n, charset))
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string:");
        String s = reader.readLine();
        System.out.println(lengthOfLongestSubstring(s));
    }

    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int best = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (lastIndex.containsKey(ch)) {
                left = Math.max(left, lastIndex.get(ch) + 1);
            }
            lastIndex.put(ch, right);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}

