package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    /*
     * Mindmap
     * ValidParentheses
     * - Inputs
     *   - string s
     * - Goal
     *   - check if brackets are valid
     * - Strategy
     *   - stack for opening brackets
     *   - match on closing
     * - Output
     *   - true/false
     * - Complexity
     *   - time: O(n)
     *   - space: O(n)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string:");
        String s = reader.readLine();
        System.out.println(isValid(s));
    }

    static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (!matches(open, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }
}
