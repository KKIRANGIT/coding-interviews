package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumRemoveToMakeValidParentheses {
    /*
     * Mindmap
     * MinimumRemoveToMakeValidParentheses
     * - Inputs
     *   - string s
     * - Goal
     *   - remove minimum parentheses to make string valid
     * - Strategy
     *   - stack indices of '(' 
     *   - mark invalid ')' and leftover '(' for removal
     * - Output
     *   - cleaned string
     * - Complexity
     *   - time: O(n)
     *   - space: O(n)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string:");
        String s = reader.readLine();
        System.out.println(minRemoveToMakeValid(s));
    }

    static String minRemoveToMakeValid(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        boolean[] remove = new boolean[s.length()];
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    remove[i] = true;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
