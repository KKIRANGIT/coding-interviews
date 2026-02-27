package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P01TwoSum {
    /*
     * Mindmap
     * TwoSum
     * - Inputs
     *   - nums[]
     *   - target
     * - Goal
     *   - find two indices i, j with nums[i] + nums[j] == target
     * - Strategy
     *   - scan once
     *   - track seen values -> index (hash map)
     *   - for each value: check complement
     * - Output
     *   - indices if found
     *   - message if not found
     * - Complexity
     *   - time: O(n)
     *   - space: O(n)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers (space or comma separated, optional brackets):");
        String numbersLine = reader.readLine();
        System.out.println("Enter target:");
        String targetLine = reader.readLine();

        int[] nums = parseNumbers(numbersLine);
        int target = Integer.parseInt(targetLine.trim());

        int[] result = twoSum(nums, target);
        if (result == null) {
            System.out.println("No solution found.");
        } else {
            System.out.println("Indices: " + result[0] + " " + result[1]);
            System.out.println("Values: " + nums[result[0]] + " " + nums[result[1]]);
        }
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer j = seen.get(complement);
            if (j != null) {
                return new int[] { j, i };
            }
            seen.put(nums[i], i);
        }
        return null;
    }

    private static int[] parseNumbers(String line) {
        if (line == null || line.trim().isEmpty()) {
            return new int[0];
        }
        String cleaned = line.replace("[", " ")
                             .replace("]", " ")
                             .replace(",", " ");
        String[] parts = cleaned.trim().split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        return nums;
    }
}

