package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingRainWater {
    /*
     * Mindmap
     * TrappingRainWater
     * - Inputs
     *   - height[]
     * - Goal
     *   - compute trapped water
     * - Strategy
     *   - two pointers
     *   - track leftMax/rightMax
     * - Output
     *   - total water
     * - Complexity
     *   - time: O(n)
     *   - space: O(1)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter heights (space or comma separated, optional brackets):");
        String numbersLine = reader.readLine();
        int[] height = parseIntArray(numbersLine);
        System.out.println(trap(height));
    }

    static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    private static int[] parseIntArray(String line) {
        if (line == null || line.trim().isEmpty()) {
            return new int[0];
        }
        String cleaned = line.replace("[", " ")
                             .replace("]", " ")
                             .replace(",", " ");
        String[] parts = cleaned.trim().split("\\s+");
        if (parts.length == 1 && parts[0].isEmpty()) {
            return new int[0];
        }
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        return nums;
    }
}
